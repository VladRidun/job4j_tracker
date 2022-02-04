package ru.job4j.inheritance;

public class Diagnosis {
    private String diagnosis;

    public Diagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return diagnosis;
    }

}
