package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java. Эффективное программирование", 500);
        Book book2 = new Book("Программирование на Java для детей, родителей, дедушек и бабушек", 600);
        Book book3 = new Book("Java Concurrency in Practice", 550);
        Book book4 = new Book("Clean code", 560);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        System.out.println();
        System.out.println("Massive of books");
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getcountPaiges() + " стр.");
        }

        System.out.println();
        System.out.println("Replace  0 to 3 .");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getcountPaiges() + " стр.");
        }

        System.out.println();
        System.out.println("Output only CleanCode");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getcountPaiges() + " стр.");
            }
        }
    }
}