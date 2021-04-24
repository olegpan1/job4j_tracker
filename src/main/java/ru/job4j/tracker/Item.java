package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return created;
    }

    public void printInfo() {
        System.out.println("Name:  " + name);
        System.out.println("ID: " + id);
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='" + name
                + '\'' + ", created=" + created + '}';
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id);
    }
}