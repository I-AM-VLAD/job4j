package ru.job4j.chapter_006.serialization;

public class Book {
    private final String author;

    public Book(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{"
                + "author='" + author + '\''
                + '}';
    }
}

