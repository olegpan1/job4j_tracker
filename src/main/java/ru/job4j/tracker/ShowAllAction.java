package ru.job4j.tracker;

import java.util.List;

public record ShowAllAction(Output out) implements UserAction {

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> all = tracker.findAll();
        out.println("=== Show all items ====");
        if (all.size() > 0) {
            for (Item it : all) {
                out.println(it);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
