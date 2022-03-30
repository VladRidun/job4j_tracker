package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class School {
        public List<Student> collect(List<Student> students, Predicate<Student> pr) {
        return students.stream()
                .filter(pr)
                .collect(Collectors.toList());
    }
}