package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        int id;
        Item item;
        String name;
        while (run) {
            showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                name = input.askStr("Enter name: ");
                item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка:  " + item);
            } else if (select == 1) {
                Item[] all = tracker.findAll();
                System.out.println("=== Show all items ====");
                if (all.length > 0) {
                    for (Item it : all) {
                        System.out.println(it);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                id = Integer.valueOf(input.askStr("Enter id: "));
                name = input.askStr("Enter name: ");
                item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка " + id + " заменена");
                } else {
                    System.out.println("Заявка " + id + " не существует, её невозможно заменить");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                id = Integer.valueOf(input.askStr("Enter id:"));
                if (tracker.delete(id)) {
                    System.out.println("Заявка " + id + " удалена");
                } else {
                    System.out.println("Заявка " + id + " не существует, её невозможно удалить");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ====");
                id = Integer.valueOf(input.askStr("Enter id:"));
                item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Найдена заявка: " + item);
                } else {
                    System.out.println("Заявка с id " + id + " не найдена");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                name = input.askStr("Enter name: ");
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
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}