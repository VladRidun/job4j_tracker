package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        String answer;
        int answerNumber = new Random().nextInt(3);
        Scanner input = new Scanner(System.in);

        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        if (answerNumber == 0) {
            answer = "Да";
        } else if (answerNumber == 1) {
            answer = "Нет";
        } else {
            answer = "Может быть";
        }
        System.out.println(question + " Ответ Оракула на этот вопрос " + answer);
    }
}
