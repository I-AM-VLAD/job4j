package ru.job4j.pojo;

public class Shop {
    public static Product[] delete(Product[] array, int indexDelete) {
        array[indexDelete] = null;
        for (int index = 0; index < array.length; index++) {
            int newIndex = index + 1;
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
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        delete(products, 0);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}