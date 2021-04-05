package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithOutNull = new Item[items.length];
        int index = 0;
        for (Item item : items
        ) {
            if (item != null) {
                itemsWithOutNull[index++] = item;
            }
        }
        itemsWithOutNull = Arrays.copyOf(itemsWithOutNull, index);
        return itemsWithOutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsEqualNames = new Item[items.length];
        int index = 0;
        for (Item item : items
        ) {
            if (item.getName().equals(key)) {
                itemsEqualNames[index++] = item;
            }
        }
        itemsEqualNames = Arrays.copyOf(itemsEqualNames, index);
        return itemsEqualNames;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        if (indexOf(id) != -1) {
            item.setId(id);
            items[indexOf(id)] = item;
            rsl = true;
        }
        return rsl;
    }
}