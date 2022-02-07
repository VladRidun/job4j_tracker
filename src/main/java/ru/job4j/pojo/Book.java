package ru.job4j.pojo;

public class Book {
    private String name;
    private int countPaiges;

    public Book(String name, int countPaiges) {
        this.name = name;
        this.countPaiges = countPaiges;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberPaiges(int numberPaiges) {
        this.countPaiges = countPaiges;
    }

    public String getName() {
        return name;
    }

    public int getcountPaiges() {
        return countPaiges;
    }
}