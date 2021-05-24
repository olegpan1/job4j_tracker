package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ListToMapTest {

    @Test
    public void listToMap() {
        List<Student> students = List.of(
                new Student(50, "Ivanov"),
                new Student(40, "Petrov"),
                new Student(40, "Ivanov"),
                new Student(70, "Sidorov"),
                new Student(90, "Smith")
        );
        ListToMap ltm = new ListToMap();
        Map<String, Student> actual = ltm.listToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student(50, "Ivanov"));
        expected.put("Petrov", new Student(40, "Petrov"));
        expected.put("Sidorov", new Student(70, "Sidorov"));
        expected.put("Smith", new Student(90, "Smith"));
        assertEquals(expected, actual);
    }
}