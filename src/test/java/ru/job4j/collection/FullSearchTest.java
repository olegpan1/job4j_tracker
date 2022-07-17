package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;

public class FullSearchTest {
    @Test
    public void extractNumber() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "First desc"),
                new Task("1", "First desc"),
                new Task("2", "Second1 desc"),
                new Task("2", "Second2 desc"),
                new Task("2", "Second3 desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = new HashSet<>(List.of("1", "2"));
        MatcherAssert.assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}