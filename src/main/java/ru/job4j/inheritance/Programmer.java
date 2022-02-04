package ru.job4j.inheritance;

import java.util.Date;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, String birthday, String language) {
        super(name, surname, education, birthday);
        this.language = language;
    }

    public void toDo() {
        System.out.println("I'm " + super.getName() + language + "programmer");
    }
}
