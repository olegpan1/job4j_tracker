package ru.job4j.tracker;

import java.util.Objects;

public record FindByIdAction(Output out) implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        out.println(Objects.requireNonNullElse(item, "Wrong id! Not found!"));
        return true;
    }
}
