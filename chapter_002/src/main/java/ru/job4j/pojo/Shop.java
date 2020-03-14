package ru.job4j.pojo;

public class Shop {
    public static Product[] delete(Product[] array, int indexDelete) {
        // удаляем выбранный элемент
        array[indexDelete] = null;
        // ДЕЛАЕМ МАССИВ БЕЗ "ДЫРОК"
        for (int index = 0; index < array.length; index++) {

            int newIndex = index + 1;
            // чтобы не выйти за пределы массива
            if ((index == array.length - 1) && array[index] == null) {
                break;
            }
            if (array[index] == null) {
                while (array[newIndex] == null && (newIndex != array.length - 1)) {
                    ++newIndex;
                }
                array[index] = array[newIndex];
                array[newIndex] = null;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        // заполняем массив
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        // вывод массива
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            // проверка
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();

        // удаляем выбранный элемент
        delete(products, 0);

        // вывод массива
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            // проверка
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}