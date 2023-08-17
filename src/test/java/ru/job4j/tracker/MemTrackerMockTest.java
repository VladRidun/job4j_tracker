package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemTrackerMockTest {
    @Test
    public void whenEditItemActionMockTrue() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
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
        Store tracker = new MemTracker();
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
        Store tracker = new MemTracker();
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
        Store tracker = new MemTracker();
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
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        Item addedItem = tracker.add(item);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        UserAction findIdAction = new FindItemByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findIdAction.execute(input, tracker);
        var date = item.getCreated();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ==="
                + ln + addedItem + ln);
    }

    @Test
    public void whenFindItemByIdActionFalse() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
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
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        Item addedItem = tracker.add(item);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        UserAction findNameAction = new FindItemByName(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item");
        findNameAction.execute(input, tracker);
        var date = item.getCreated();
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by name ==="
                + ln + addedItem + ln);
    }

    @Test
    public void whenFindItemByNameMockFalse() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
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
