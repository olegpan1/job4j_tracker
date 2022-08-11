package ru.job4j.tracker;

import java.util.List;

public record DeleteAllAction(Output out) implements UserAction {

    @Override
    public String name() {
        return "=== Delete all  Items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> all = tracker.findAll();
        int numberOfItems = all.size();
        System.out.println(numberOfItems + " Items are removed, please wait!");
        for (int i = numberOfItems - 1; i >= 0; i--) {
            tracker.delete(all.get(i).getId());
        }
        out.println("Successfully deleted all Items!");
        return true;
    }
}
