package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = per -> per.getName().contains(key);
        Predicate<Person> predicateSurname = per -> per.getSurname().contains(key);
        Predicate<Person> predicatePhone = per -> per.getPhone().contains(key);
        Predicate<Person> predicateAddress = per -> per.getName().contains(key);
        Predicate<Person> combine = predicateName.or(predicateSurname).or(predicatePhone).or(predicateAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}