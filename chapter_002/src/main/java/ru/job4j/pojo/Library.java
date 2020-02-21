package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("book1",100);
        Book book2 = new Book("book2",200);
        Book book3 = new Book("book3",300);
        Book cleanCode = new Book("cleanCode",400);

        Book [] booksArr = new Book[4];

        booksArr[0] = book1;
        booksArr[1] = book2;
        booksArr[2] = book3;
        booksArr[3] = cleanCode;

        for (int index = 0; index < booksArr.length; index++) {
            Book bk = booksArr [index];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }

        System.out.println("Replace book1 to cleanCode.");
        Book temp = new Book("Oil", 11);
        booksArr[0] = cleanCode;
        booksArr[3] = book1;

        for (int index = 0; index < booksArr.length; index++) {
            Book bk = booksArr [index];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }

        System.out.println("Books with the name 'cleanCode'.");
        for (int index = 0; index < booksArr.length; index++) {
            Book bk = booksArr[index];
            if (bk.getName() == "cleanCode") {
                System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
            }
        }
    }
}
