package ru.job4j.tracker.oop;

public class Error {
    private boolean errorTrue;
    private int number;
    private String name;

    public Error() {

    }

    public Error(String name, int number, boolean errorTrue) {
        this.name = name;
        this.number = number;
        this.errorTrue = errorTrue;
    }

    public void printInfo() {
        System.out.println("Имя ошибки: " + name);
        System.out.println("Kоличество: " + number);
        System.out.println("Часто встречается: " + errorTrue);
    }

    public static void main(String[] args) {
        Error error = new Error("Fatality", 13, true);
        error.printInfo();

    }
}