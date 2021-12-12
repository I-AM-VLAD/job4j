package ru.job4j.chapter_004.streamAPI;
import java.util.List;
import java.util.stream.Collectors;
public class ListStudentToMapStudent {
    public static  void  main(String[] args) {
        List.of(
                    new Student("Петров", 25),
                    new Student("Иванов", 54),
                    new Student("Кузнецов", 78)
            ).stream().distinct().collect(
                    Collectors.toMap(
                            student -> student.getSurname(),
                            student -> student
            )
        );
    }
}
