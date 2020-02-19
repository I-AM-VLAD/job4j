package ru.job4j.profession;

public class Surgeon extends Doctor {
    private String appendicitis;

    public Surgeon(String varConstructor) {
        this.appendicitis = varConstructor;
    }

    public String cut() {
        return appendicitis;
    }
}
