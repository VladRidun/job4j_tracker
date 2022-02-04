package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {
    private String directionOftraining;

    public Builder(String name, String surname, String education, String birthday, String directionOftraining) {
        super(name, surname, education, birthday);
        this.directionOftraining = directionOftraining;
    }

    public void directionTo() {
        System.out.println(directionOftraining);
    }
}
