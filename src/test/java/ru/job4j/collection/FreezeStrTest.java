package ru.job4j.collection;


import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        MatcherAssert.assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        MatcherAssert.assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        MatcherAssert.assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }

    @Test
    public void whenDifLength() {
        MatcherAssert.assertThat(FreezeStr.eq("helloo", "hello"), is(false));
    }

    @Test
    public void whenEqual() {
        MatcherAssert.assertThat(FreezeStr.eq("Hello world!", "world! Hello"), is(true));
    }
}