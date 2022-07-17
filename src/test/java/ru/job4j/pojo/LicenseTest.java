package ru.job4j.pojo;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class LicenseTest {

    @Test
    public void testEquals() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        MatcherAssert.assertThat(first, is(second));
    }
}