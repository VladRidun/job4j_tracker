package ru.job4j.tracker.oop;

public class Cat {
    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        String say = peppy.sound();
        System.out.println("peppy says " + say);
    }
}