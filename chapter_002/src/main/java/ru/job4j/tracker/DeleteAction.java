package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "3. Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        System.out.println("=== Delete an Item ====");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        tracker.delete(id);

        return true;
    }
}
