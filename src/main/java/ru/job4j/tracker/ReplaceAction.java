package ru.job4j.tracker;

public record ReplaceAction(Output out) implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Item is successfully replaced!");
        } else {
            out.println("Wrong id!");
        }
        return true;
    }
}
