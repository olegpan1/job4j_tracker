package ru.job4j.stream;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;

public class AnalyzeTest {

    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                ).stream()
        );
        MatcherAssert.assertThat(average, is(100D));
    }

    @Test
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60)))
                ).stream()
        );
        MatcherAssert.assertThat(average, is(80D));
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                new Subject("Lang", 60)))
                ).stream()
        );
        MatcherAssert.assertThat(average, is(List.of(
                new Tuple("Ivanov", 100D),
                new Tuple("Petrov", 60D)
        )));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                new Subject("Lang", 60)))
                ).stream()
        );
        MatcherAssert.assertThat(average, is(List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 80D)
        )));
    }

    @Test
    public void whenBestPupil() {
        Tuple best = Analyze.bestStudent(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                new Subject("Lang", 60)))
                ).stream()
        );
        MatcherAssert.assertThat(best, is(new Tuple("Ivanov", 200D)));
    }

    @Test
    public void whenBestSubject() {
        Tuple best = Analyze.bestSubject(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 40))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                new Subject("Lang", 60)))
                ).stream()
        );
        MatcherAssert.assertThat(best, is(new Tuple("Math", 160D)));
    }
}