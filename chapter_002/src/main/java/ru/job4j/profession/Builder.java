package ru.job4j.profession;

public class Builder extends Engineer {
    private String house;

    public Builder(String varConstructor) {
        this.house = varConstructor;
    }

    public String build() {
        return house;
    }


}
