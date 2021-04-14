package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
