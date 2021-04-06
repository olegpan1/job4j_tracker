package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        int id;
        Item item;
        String name;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("Создаем новую заявку");
                System.out.print("Введите имя новой заявки: ");
                name = scanner.nextLine();
                item = new Item(name);
                tracker.add(item);
                System.out.println("Создана заявка с именем: " + name);
            } else if (select == 1) {
                Item[] all = tracker.findAll();
                System.out.println("Список всех заявок: ");
                for (Item it : all) {
                    System.out.println(it);
                }
            } else if (select == 2) {
                System.out.println("Введите id заявки, которую будем заменять");
                id = Integer.valueOf(scanner.nextLine());
                System.out.println("Введите имя заявки, на которую будем заменять");
                name = scanner.nextLine();
                item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка " + id + " заменена");
                } else {
                    System.out.println("Заявка " + id + " не существует, её невозможно заменить");
                }
            } else if (select == 3) {
                System.out.println("Введите id заявки, которую будем удалять");
                id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка " + id + " удалена");
                } else {
                    System.out.println("Заявка " + id + " не существует, её невозможно удалить");
                }
            } else if (select == 4) {
                System.out.println("Введите id заявки, которую будем искать");
                id = Integer.valueOf(scanner.nextLine());
                item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Найдена заявка: " + item.toString());
                } else {
                    System.out.println("Заявка с id " + id + " не найдена");
                }
            } else if (select == 5) {
                System.out.println("Введите имя заявок, которые хотите найти");
                name = scanner.nextLine();
                Item[] findByName = tracker.findByName(name);
                if (findByName.length > 0) {
                    System.out.println("Список заявок с именем: " + name);
                    for (Item it : findByName) {
                        System.out.println(it);
                    }
                } else {
                    System.out.println("Заявки с именем " + name + " не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}