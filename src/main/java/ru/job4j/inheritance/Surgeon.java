package ru.job4j.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {
    private String kind;

    public Surgeon(String name, String surname, String education, String birthday, String kind) {
        super(name, surname, education, birthday);
        this.kind = kind;
    }

    public void doOperationCardio(String kind) {
        if (kind.equals("Cardio")) {
            System.out.println("I can do cardio operation to your hurt");
        }
    }

}