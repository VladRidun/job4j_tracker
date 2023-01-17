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

import java.util.List;
import java.util.Properties;


import static org.junit.jupiter.api.Assertions.*;

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
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
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
}