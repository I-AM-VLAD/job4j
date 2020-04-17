package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "5. Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        System.out.println("=== Find items by name ====");

        // вводим NAME
        System.out.println("Введите name");
        String in = input.askStr("");

        Item[] resultNames = tracker.findByName(in);

        // ПРОВЕРКА
        /*"Элемента с таким name не существует"*/
        //////////////////////////////////////

        // вывод массива имен на экран
        for (int i = 0; i < resultNames.length; i++) {
            System.out.print(resultNames[i].getName() + " ");
        }

        System.out.println();

        return true;
    }
}
