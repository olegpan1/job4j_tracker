package ru.job4j.tracker;

public class AddManyAction implements UserAction {

    private final Output out;

    public AddManyAction(Output out) {
        this.out = out;
    }

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
        out.println("Successfully added: " + tracker.findAll().size() + " Items!");
        return true;
    }
}
