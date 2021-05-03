package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompareByNameUp() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Fix1", 2),
                new Job("Fix2", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByNameDown() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Fix1", 2),
                new Job("Fix2", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByPriorityUp() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("Fix", 1),
                new Job("Fix", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriorityDown() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Fix", 1),
                new Job("Fix", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByNameAndPriorityUp() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix1", 1),
                new Job("Fix1", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriorityUpAndNameDown() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Fix1", 2),
                new Job("Fix2", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

}