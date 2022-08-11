package ru.job4j.tracker;

public record AddManyAction(Output out) implements UserAction {

    @Override
    public String name() {
        return "=== Create many  Items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int number = Integer.parseInt(input.askStr("Enter number of Items: "));
        for (int i = 0; i < number; i++) {
            tracker.add(new Item(Integer.toString(i)));
        }
        out.println("Successfully added: " + number + " Items!");
        return true;
    }
}
