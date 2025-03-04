package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;

@Ignore
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7, 8),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        MatcherAssert.assertThat(result, is(expect));
    }
}