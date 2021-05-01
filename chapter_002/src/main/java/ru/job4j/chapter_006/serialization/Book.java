package ru.job4j.chapter_006.serialization;
import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "book")
public class Book {
    @XmlAttribute
    private String author;

    public Book() {}

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
