package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] findByName = tracker.findByName(name);
        if (findByName.length > 0) {
            System.out.println("Список заявок с именем: " + name);
            for (Item it : findByName) {
                System.out.println(it);
            }
        } else {
            System.out.println("Заявки с именем " + name + " не найдены");
        }
        return true;
    }
}
