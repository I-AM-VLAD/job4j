package ru.job4j.chapter_004.streamAPI;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.List;
public class SchoolTest {
    @Test
    public  void when0to50then9C() {
        List<Student> students = List.of(
            new Student("Петров", 25),
            new Student("Кузнецов", 54),
            new Student("Иванов", 78)
        );
        List<Student> result = School.collect(students,
                student -> student.getScore() >= 0 && student.getScore() <= 50);
        List<Student> expected = List.of(
             new Student("Петров", 25)
        );
        assertThat(result, is(expected));
    }

    @Test
    public  void when50to70then9B() {
        List<Student> students = List.of(
                new Student("Петров", 25),
                new Student("Кузнецов", 54),
                new Student("Иванов", 78)
        );
        List<Student> result = School.collect(students,
                student -> student.getScore() > 50 && student.getScore() <= 70);
        List<Student> expected = List.of(
                new Student("Кузнецов", 54)
        );
        assertThat(result, is(expected));
    }

    @Test
    public  void when70to100then9A() {
        List<Student> students = List.of(
                new Student("Петров", 25),
                new Student("Кузнецов", 54),
                new Student("Иванов", 78)
        );
        List<Student> result = School.collect(students,
                student -> student.getScore() > 70 && student.getScore() <= 100);
        List<Student> expected = List.of(
                new Student("Иванов", 78)
        );
        assertThat(result, is(expected));
    }
}
