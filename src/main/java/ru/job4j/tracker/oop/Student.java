package ru.job4j.tracker.oop;

public class Student {
    public static void main(String[] args) {
        Student petya = new Student();
        int i = 0;
        do {
            petya.music();
            petya.song();
            i++;
        } while (i != 3);
    }

    public void music() {
        System.out.println("tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }
}
