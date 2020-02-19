package ru.job4j.profession;

public class Programmer extends Engineer {
    private String program;

    public Programmer(String varConstructor) {
        this.program = varConstructor;
    }

    public String write() {
        return program;
    }
}
