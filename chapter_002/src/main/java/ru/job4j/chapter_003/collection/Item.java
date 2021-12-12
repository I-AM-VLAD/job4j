package ru.job4j.chapter_003.collection;

public class Item implements Comparable <Item> {
    private String id;
    private String name;

    public Item(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Item{" +
                "id ='" + id + '\'' +
                ", name =" + name +
                '}';
    }
    @Override
    public int compareTo(Item another) {
        return id.compareTo(another.id);
    }
}
