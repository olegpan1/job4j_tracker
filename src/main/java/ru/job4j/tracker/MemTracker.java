package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemTracker implements Store {

    private final List<Item> items = new ArrayList<>();

    private int id = 0;

    private Connection cn;

    @Override
    public void init() {
        try (InputStream in = MemTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public Item add(Item item) {
        item.setId(id++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items.set(index, item);
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }

    private int indexOf(int id) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
