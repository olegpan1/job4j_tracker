package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id:");
        if (tracker.delete(id)) {
            System.out.println("Заявка " + id + " удалена");
        } else {
            System.out.println("Заявка " + id + " не существует, её невозможно удалить");
        }
        return true;
    }
}
