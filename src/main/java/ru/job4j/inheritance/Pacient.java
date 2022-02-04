package ru.job4j.inheritance;

public class Pacient {
    private String name;
    private int age;
    private Diagnosis diagnosis;

    public Pacient(String name, int age, Diagnosis diagnosis) {
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Diagnosis getDiagnose() {
        return diagnosis;
    }
}