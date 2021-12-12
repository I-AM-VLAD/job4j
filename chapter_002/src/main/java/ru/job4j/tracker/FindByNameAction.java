package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "5. Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        String in = input.askStr("Введите name ");
        for (Item item : tracker.findByName(in)) {
            System.out.println(String.format("%s %s", item.getId(), item.getName()));
        }

        return true;
    }
}
