package ru.job4j.pojo;

public class Student {
    private String name;
    private String surname;
    private String secondName;
    private int group;
    private String receiptDate;

    public Student(String surname, String name, String secondName, int group, String receiptDate) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.group = group;
        this.receiptDate = receiptDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getGroup() {
        return group;
    }

    public String getReceiptDate() {
        return receiptDate;
    }
}