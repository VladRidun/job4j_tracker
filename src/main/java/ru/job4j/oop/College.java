package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        /**
         * up casting
         */
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object oStudent = student;
    }
}
