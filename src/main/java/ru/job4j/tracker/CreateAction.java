package ru.job4j.tracker;

public record CreateAction(Output out) implements UserAction {

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Item successfully added!");
        return true;
    }
}

