package ru.job4j.tracker;

import java.util.List;

public class DeleteAllAction implements UserAction {

    private final Output out;

    public DeleteAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete all  Items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> all = tracker.findAll();
        int numberOfItems = all.size();
        System.out.println(numberOfItems + " Items are removed, please wait!");
        while (numberOfItems > 0) {
            tracker.delete(all.get(0).getId());
            numberOfItems--;
        }
        out.println("Successfully deleted all Items!");
        return true;
    }
}
