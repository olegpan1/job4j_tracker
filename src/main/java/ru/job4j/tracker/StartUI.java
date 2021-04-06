package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item {
    public static void main(String[] args) {
        Item time = new Item("Time");
        LocalDateTime currentDateTime = time.getTime();
        System.out.println("Текущие дата и время до форматирования: " + currentDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);

        Tracker tracker = new Tracker();
        Item place1 = new Item("Place1");
        Item place2 = new Item("Place2");
        Item place3 = new Item("Place3");
        tracker.add(place1);
        tracker.add(place2);
        tracker.add(place3);
        System.out.println(place1);
    }
}
