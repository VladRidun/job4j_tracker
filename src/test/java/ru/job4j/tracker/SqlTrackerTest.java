package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("TRUNCATE TABLE items RESTART IDENTITY")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("itemVlad"));
        tracker.add(item);
        assertTrue(tracker.findById(item.getId()).equals(item));
    }

    @Test
    public void whenTestFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("itemVlad"));
        Item result = tracker.findById(item.getId());
        assertEquals(result.getName(), (item.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayAsSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item second1 = tracker.add(new Item("First"));
        Item second2 = tracker.add(new Item("First"));
        assertEquals(List.of(second1, second2), tracker.findByName(second1.getName()));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertEquals(result.get(1).getName(), (second.getName()));
    }

    @Test
    public void whenTestFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        assertEquals(List.of(first, second), tracker.findAll());
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = tracker.add(new Item("Bug"));
        int id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertEquals(tracker.findById(id).getName(), ("Bug with description"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = tracker.add(new Item("Bug"));
        int id = bug.getId();
        tracker.delete(id);
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenEditItemActionMockTrue() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItemAction rep = new EditItemAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Edit item ===" + ln + "Заявка изменена успешно." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenEditItemActionMockFalse() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItemAction rep = new EditItemAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Edit item ===" + ln + "Item with id=2 not found." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Replaced item");
    }

    @Test
    public void whenDeleteItemActionMockTrue() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        tracker.add(new Item("Item"));
        UserAction deleteAction = new DeleteItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ==="
                + ln + "Заявка удалена успешно." + ln);
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void whenDeleteItemActionMockFalse() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        tracker.add(new Item("Item"));
        UserAction deleteAction = new DeleteItemAction(out);
        Input input = mock(Input.class);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ==="
                + ln + "Ошибка удаления заявки." + ln);
    }

    @Test
    public void whenFindItemByIdActionTrue() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        tracker.add(item);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        UserAction findIdAction = new FindItemByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findIdAction.execute(input, tracker);
        var date = item.getCreated();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ==="
                + ln + "id=1, name='Item', created=" + formatter.format(date) + ln);
    }

    @Test
    public void whenFindItemByIdActionFalse() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        tracker.add(new Item("Item"));
        UserAction findIdAction = new FindItemByIdAction(out);
        Input input = mock(Input.class);
        findIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ==="
                + ln + "Заявка с введенным id: 0 не найдена." + ln);
    }

    @Test
    public void whenFindItemByNameMockTrue() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        tracker.add(new Item("Item"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        UserAction findNameAction = new FindItemByName(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item");
        findNameAction.execute(input, tracker);
        var date = item.getCreated();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by name ==="
                + ln + "id=1, name='Item', created=" + formatter.format(date) + ln);
    }

    @Test
    public void whenFindItemByNameMockFalse() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        tracker.add(new Item("ItemFalse"));
        UserAction findNameAction = new FindItemByName(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item");
        findNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by name ==="
                + ln + "Заявки с именем: " + "Item" + " не найдены." + ln);
    }
}