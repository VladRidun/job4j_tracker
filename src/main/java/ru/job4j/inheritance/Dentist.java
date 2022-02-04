package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {
    private int tooth;

    public Dentist(String name, String surname, String education, String birthday, int tooth) {
        super(name, surname, education, birthday);
        this.tooth = tooth;
    }

    public void toCure() {
        System.out.println("Вoctor cured" + tooth + " teeth");
    }

}
