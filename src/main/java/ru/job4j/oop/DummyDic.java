package ru.job4j.oop;

public class DummyDic {
    public static void main(String[] args) {
        DummyDic dum = new DummyDic();
        String eng = dum.engToRus("Hello!!!");
        System.out.println(eng);
    }

    public String engToRus(String eng) {
        String word = "Неизвестное слово " + eng;
        return word;
    }
}