package ru.job4j.chapter_006.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {
    @XmlAttribute
    private boolean webSite;

    @XmlAttribute
    private int visitors;

    private Book book;

    @XmlAttribute
    private String director;

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private String[] employees;

    public Library() {}
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
}
