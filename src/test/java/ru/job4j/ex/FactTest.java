package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenArgumentLessZero() {
        Fact.calc(-3);
    }

    @Test
    public void whenArgumentMoreZero() {
        int rsl = Fact.calc(4);
        assertEquals(24, rsl);
    }
}