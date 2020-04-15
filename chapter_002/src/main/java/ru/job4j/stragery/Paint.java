package ru.job4j.stragery;

public class Paint {
    public static void draw(Shape shape) {
        System.out.println(shape.draw());
    }


    public static void main(String[] args) {
        Paint.draw(new Square());
        Paint.draw(new Triangle());
    }
}

