package ru.job4j.profession;

public class Dentist extends Doctor {
    private String Tooth;

    public Dentist(String varConstructor) {
        this.Tooth = varConstructor;
    }

    public String Insert() {
        return Tooth;
    }
}
