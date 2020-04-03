package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {

        // ЦИКЛ ДЛЯ ВЫБОРА ПУНКТА МЕНЮ
        boolean run = true;
        while (run) {
            this.showMenu();

            // считываем выбор пользователя
            System.out.print("Select: ");
            int select = input.askInt("");

            // если выбор 0
            if (select == 0) {
                System.out.println("=== Add new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr("");
                Item item = new Item(name);
                tracker.add(item);
            }

            // если выбор 1
            else if (select == 1) {
                System.out.println("=== Show all items ====");

                // массив заявок
                Item[] result = tracker.findAll();

                // ПРОВЕРКА
                /*"Если заявок нет"*/
                //////////////////////////////////////

                // вывод массива заявок на экран
                for(int i = 0; i < result.length; i++){
                    System.out.print(result[i].getName() + " ");
                }
                System.out.println();
            }

            // если выбор 2
            else if (select == 2) {
                System.out.println("Такой функции пока не существует!");
            }
            // если выбор 3
            else if (select == 3) {
                System.out.println("Такой функции пока не существует!");
            }

            // если выбор 4
            else if (select == 4) {
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
            }

            // если выбор 5
            else if (select == 5) {
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
            }

            // если выбор 6
            else if (select == 6) {
                System.out.println("=== Exit Program ====");
                run = false;
            }
            // если не правильный выбор
            else {
                System.out.println("Выберите правильную цифру!");
            }
        }
    }

    // МЕНЮ
    private void showMenu() {
        System.out.println("MENU.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    //
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();

        new StartUI().init(input, tracker);
    }
}

