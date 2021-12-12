package ru.job4j.chapter_005.generic;

public class User extends Base{

    public User(final String id) {
        super(id);
    }

    public String getId() {
        return super.getId();
    }
}