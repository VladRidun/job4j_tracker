package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox box1 = new Jukebox();
        Jukebox box2 = new Jukebox();
        Jukebox box3 = new Jukebox();
        box1.music(1);
        box2.music(2);
        box3.music(3);
    }

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }
}