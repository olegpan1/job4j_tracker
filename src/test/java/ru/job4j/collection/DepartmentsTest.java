package ru.job4j.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    private ByteArrayOutputStream output;
    private PrintStream old;

    @Before
    public void setUpStreams() {
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(old);
    }

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k2/sk1/ssk2", "k1/sk1/ssk2", "k1/sk1/ssk1",
                "k2/sk1/ssk1", "k2/sk2");
        List<String> expect = List.of("k2", "k2/sk1", "k2/sk1/ssk2",
                "k1", "k1/sk1", "k1/sk1/ssk2", "k1/sk1/ssk1", "k2/sk1/ssk1", "k2/sk2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortAsc() {
        List<String> input = Arrays.asList("k2/sk1/ssk2", "k1/sk1/ssk2", "k1/sk1/ssk1",
                "k2/sk1/ssk1", "k2/sk2", "k1/sk2", "k1");
        List<String> expect = List.of("k1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2",
                  "k2/sk1/ssk1", "k2/sk1/ssk2", "k2/sk2");
        Departments.sortAsc(input);
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void sortDesc() {
        List<String> input = Arrays.asList("k2/sk1/ssk2", "k1/sk1/ssk2", "k1/sk1/ssk1",
                "k2/sk1/ssk1", "k2/sk2", "k1/sk2", "k2", "k1");
        List<String> expect = List.of("k2", "k2/sk1/ssk1", "k2/sk1/ssk2", "k2/sk2",
                "k1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2");
        Departments.sortDesc(input);
        assertEquals(expect.toString(), output.toString());
    }
}