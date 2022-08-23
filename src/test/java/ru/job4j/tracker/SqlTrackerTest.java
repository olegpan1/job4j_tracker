package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        MatcherAssert.assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenAddedThenReplaced() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOld = tracker.add(new Item("itemOld"));
        Item itemNew = new Item("itemNew");
        assertTrue(tracker.replace(itemOld.getId(), itemNew));
        MatcherAssert.assertThat(tracker.findById(itemOld.getId()).getName(), is("itemNew"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        assertTrue(tracker.delete(item1.getId()));
        assertNull(tracker.findById(item1.getId()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        tracker.add(new Item("item3"));
        assertEquals(3, tracker.findAll().size());
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertEquals(tracker.findByName("item2"), List.of(item2));
        assertEquals(tracker.findByName("tem"), List.of(item1, item2, item3));
        assertEquals(tracker.findByName("qqq"), List.of());

    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById(item1.getId());
        assertEquals(item1, result);
        result = tracker.findById(item2.getId());
        assertNotEquals(item1, result);
    }
}