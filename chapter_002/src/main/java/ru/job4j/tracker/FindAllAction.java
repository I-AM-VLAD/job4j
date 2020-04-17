package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "1. Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        System.out.println("=== Show all items ====");

        // массив заявок
        Item[] result = tracker.findAll();

        // ПРОВЕРКА
        /*"Если заявок нет"*/
        //////////////////////////////////////

        // вывод всех имен
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i].getName() + " ");
        }
        System.out.println();

        // вывод всех ID
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i].getId() + " ");
        }
        System.out.println();

        return true;
    }
}
