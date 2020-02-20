package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Vlad ");
        student.setGroup("121-16-1 ");
        student.setReceiptDate("01.09.16");
        System.out.println(student.getFullName() + student.getGroup() + student.getReceiptDate());
    }
}

