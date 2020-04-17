package ru.job4j.tracker;


public class StartUI {





    // ВЫБОР ПУНКТА МЕНЮ
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }


    // МЕНЮ
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(actions[index].name());
        }
    }


    // ГЛАВНАЯ ФУНКЦИЯ
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),

                new DeleteAction(),
                new FindByIdAction(),

                new FindByNameAction(),
        };
        new StartUI().init(input, tracker, actions);
    }
}

