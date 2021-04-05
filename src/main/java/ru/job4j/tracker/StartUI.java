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
        tracker.add(time);
        tracker.findById(1).printInfo();
    }
}
