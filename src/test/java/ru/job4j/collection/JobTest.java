package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompareByNameUp() {
        Comparator<Job> cmpName = new JobDescByNameUp();
        int rsl = cmpName.compare(
                new Job("Fix1", 2),
                new Job("Fix2", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByNameDown() {
        Comparator<Job> cmpName = new JobDescByNameDown();
        int rsl = cmpName.compare(
                new Job("Fix1", 2),
                new Job("Fix2", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByPriorityUp() {
        Comparator<Job> cmpName = new JobDescByPriorityUp();
        int rsl = cmpName.compare(
                new Job("Fix", 1),
                new Job("Fix", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriorityDown() {
        Comparator<Job> cmpName = new JobDescByPriorityDown();
        int rsl = cmpName.compare(
                new Job("Fix", 1),
                new Job("Fix", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByNameAndPriorityUp() {
        Comparator<Job> cmpNamePriority = new JobDescByNameUp()
                .thenComparing(new JobDescByPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("Fix1", 1),
                new Job("Fix2", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriorityUpAndNameDown() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityUp()
                .thenComparing(new JobDescByNameDown());
        int rsl = cmpNamePriority.compare(
                new Job("Fix1", 2),
                new Job("Fix2", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

}