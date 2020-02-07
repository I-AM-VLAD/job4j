package ru.job4j.tracker;

public class Animal {
    private String name;

    public Animal () {
    }

    public Animal (String varConstructor) {
        this.name = varConstructor;
    }

    public static void main(String[] args) {
        Animal animal = new Animal("jgkjhj");
    }
}


