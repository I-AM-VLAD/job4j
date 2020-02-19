package ru.job4j.profession;

public class Doctor extends Profession {
    private String patient;

    public Doctor() {
    }

    public Doctor(String varConstructor) {
        this.patient = varConstructor;
    }

    public String take() {
        return patient;
    }
}
