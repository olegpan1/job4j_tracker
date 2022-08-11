package ru.job4j.tracker;

import java.util.List;

public record FindByNameAction(Output out) implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Item not found!");
        }
        return true;
    }
}
