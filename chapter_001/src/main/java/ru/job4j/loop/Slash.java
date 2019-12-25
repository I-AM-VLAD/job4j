package ru.job4j.loop;

public class Slash {
    public static void draw(int size) {
        int reverse = size;
        for (int i = 0; i < size; i++) {
            reverse --;
            for (int j = 0; j < size; j++) {
                if (i == j)
                    System.out.print("0");
                else if (j == reverse)
                    System.out.print("0");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Draw by 3");
        draw(3);
        System.out.println("Draw by 5");
        draw(5);
    }
}
