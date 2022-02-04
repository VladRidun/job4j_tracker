package ru.job4j.inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
        Diagnosis diagnosis = new Diagnosis("Аритмия");
        Pacient pacient = new Pacient("Влад", 32, diagnosis);
        Surgeon doctor = new Surgeon("Иван", "Иванов", "Cardio-hirurg", "01.01.1981", "Cardio");

        System.out.println("Доктор " + doctor.getName() + " поставил диагноз " + doctor.heal(pacient) + " пациенту " + pacient.getName());
    }
}