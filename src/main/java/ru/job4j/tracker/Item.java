package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

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

    public static void main(String[] args) {
        Item first = new Item();
        Item second = new Item("Second");
        Item third = new Item("Third", 3);
        first.printInfo();
        second.printInfo();
        third.printInfo();
    }
}