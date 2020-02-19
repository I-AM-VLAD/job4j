package ru.job4j.profession;

public class Engineer extends Profession {
    private String project;

    public Engineer() {
    }

    public Engineer(String varConstructor) {
        this.project = varConstructor;
    }

    public String create() {
        return project;
    }
}
