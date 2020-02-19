package ru.job4j.profession;

public class Profession {
    private String name;

    public Profession() {
    }

    public Profession(String varConstructor) {
       this.name = varConstructor;
    }

    public String getName() {
        return name;
    }
}
