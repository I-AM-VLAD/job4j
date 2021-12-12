package ru.job4j.chapter_004.streamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(student -> student != null)
                .sorted((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore()))
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
