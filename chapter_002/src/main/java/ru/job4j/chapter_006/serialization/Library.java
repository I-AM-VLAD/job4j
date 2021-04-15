package ru.job4j.chapter_006.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Library {
    private final boolean webSite;
    private final int visitors;
    private final Book book;
    private final String director;
    private final String[] employees;

    public Library(boolean webSite, int visitors, Book book, String director, String... employees) {
        this.webSite = webSite;
        this.visitors = visitors;
        this.book = book;
        this.director = director;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Library{"
                + "webSite=" + webSite
                + ", visitors=" + visitors
                + ", book=" + book
                + ", director=" + director
                + ", employees=" + Arrays.toString(employees)
                + '}';
    }
    public static void main(String[] args) {
        final Library library = new Library(false, 30, new Book("Lermontov"), "Petrov", "Ivanova", "Maksimov");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(library));

        /* Модифицируем json-строку */
        final String libraryJson =
                "{"
                        + "\"webSite\":true,"
                        + "\"visitors\":35,"
                        + "\"book\":"
                        + "{"
                        + "\"author\":\"Pushkin\""
                        + "},"
                        + "\"director\":\"Grigoriev\","
                        + "\"employees\":"
                        + "[\"Vlad\",\"Anna\"]"
                        + "}";
        final Library libraryMod = gson.fromJson(libraryJson, Library.class);
        System.out.println(libraryMod);
    }
}
