package ru.job4j.tracker.oop;

public class Cat {
    private String name;
    private String food;

    public void show() {
        System.out.println("Кличка кота " + this.name);
        System.out.println("Что любит поесть " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        Cat vaska = new Cat();
        Cat pushok = new Cat();

        String say = peppy.sound();
        System.out.println("peppy says " + say);

        vaska.giveNick("Vaska");
        vaska.eat("Meet");
        vaska.show();
        pushok.giveNick("Pushok");
        pushok.eat("Wiskas");
        pushok.show();
    }
}