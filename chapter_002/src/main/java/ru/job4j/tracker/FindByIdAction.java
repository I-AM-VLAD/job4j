package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "4. Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        System.out.println("=== Find item by Id ====");

        // вводим ID
        System.out.println("Введите ID");
        String in = input.askStr("");
        Item resultID = tracker.findById(in);

        // проверка
        if(resultID == null) {
            System.out.println("Элемента с таким ID не существует");
        } else {
            System.out.println(resultID.getName());
        }

        return true;
    }
}
