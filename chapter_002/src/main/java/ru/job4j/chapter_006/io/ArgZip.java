package ru.job4j.chapter_006.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 3) {
            throw new IllegalArgumentException("Root folder is null.");
        }
        return true;
    }

    public String directory() {
        return args[0].split("-")[1].split("=")[1];
    }

    public String exclude() {
        return args[1].split("-")[1].split("=")[1];
    }

    public String output() {
        return args[2].split("-")[1].split("=")[1];
    }
}
