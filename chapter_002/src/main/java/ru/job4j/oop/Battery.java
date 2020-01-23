package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int valueLoad) {
        this.load = valueLoad;
    }

    public void exchange(Battery another, int difference) {
        another.load = another.load + difference;
        this.load = this.load - difference;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(15);
        System.out.println("first : " + first.load + ". second : " + second.load);
        first.exchange(second, 5);
        System.out.println("first : " + first.load + ". second : " + second.load);
    }
}
