package ru.job4j.map;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.is;

public class CollegeTest {
    @Test
    public void whenAccountIsOptionalEmpty() {
        Map<Student, Set<SubjectOld>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOld("Math", 70),
                        new SubjectOld("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOld("Economic", 75),
                        new SubjectOld("Sociology", 65)
                )
        );
        College college = new College(students);
        MatcherAssert.assertThat(college.findByAccount("000010"), is(Optional.empty()));
    }

    @Test
    public void whenAccountIsOptionalNotEmpty() {
        Map<Student, Set<SubjectOld>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOld("Math", 70),
                        new SubjectOld("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOld("Economic", 75),
                        new SubjectOld("Sociology", 65)
                )
        );
        College college = new College(students);
        MatcherAssert.assertThat(college.findByAccount("000001").get().getGroup(), is("201-18-15"));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithNotFoundAccount() {
        Map<Student, Set<SubjectOld>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOld("Math", 70),
                        new SubjectOld("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOld("Economic", 75),
                        new SubjectOld("Sociology", 65)
                )
        );
        College college = new College(students);
        MatcherAssert.assertThat(college.findBySubjectName("000010", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithFoundAccount() {
        Map<Student, Set<SubjectOld>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOld("Math", 70),
                        new SubjectOld("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOld("Economic", 75),
                        new SubjectOld("Sociology", 65)
                )
        );
        College college = new College(students);
        MatcherAssert.assertThat(college.findBySubjectName("000001", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalNotEmpty() {
        Map<Student, Set<SubjectOld>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOld("Math", 70),
                        new SubjectOld("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOld("Economic", 75),
                        new SubjectOld("Sociology", 65)
                )
        );
        College college = new College(students);
        MatcherAssert.assertThat(college.findBySubjectName("000002", "Sociology").get().getScore(), is(65));
    }
}