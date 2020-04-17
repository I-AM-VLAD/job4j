package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "2. Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        System.out.println(" === Update item ====");
        String id = input.askStr("Enter id:");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item(name);
        item.setId(id);
        tracker.replace(id, item);

        return true;
    }
}
