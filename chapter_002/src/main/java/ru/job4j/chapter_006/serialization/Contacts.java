package ru.job4j.chapter_006.serialization;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class Contacts {

    @XmlAttribute
    private String phone;

    public Contacts() {
    }

    public Contacts(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contacts{"
                + "phone='" + phone + '\''
                + '}';
    }
}
