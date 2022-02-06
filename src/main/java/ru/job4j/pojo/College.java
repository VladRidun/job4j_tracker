package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student("Ридун", "Владислав", "Валерьевич", 131, "26.07.2009");
        System.out.println(student.getSurname() + "\n"
                + student.getName() + "\n"
                + student.getSecondName() + "\n"
                + "группа " +  student.getGroup() + "\n"
                + student.getReceiptDate());
    }
}
