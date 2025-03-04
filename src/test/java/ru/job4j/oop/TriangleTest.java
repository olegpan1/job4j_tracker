package ru.job4j.oop;
import static org.hamcrest.Matchers.closeTo;


import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void rectangular() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 3);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        MatcherAssert.assertThat(rsl, closeTo(3, 0.001));
    }

    @Test
    public void isosceles() {
        Point a = new Point(3, 1);
        Point b = new Point(4, 2);
        Point c = new Point(5, 1);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        MatcherAssert.assertThat(rsl, closeTo(1, 0.001));
    }

    @Test
    public void negativeCoordinates() {
        Point a = new Point(2, 0);
        Point b = new Point(4, 0);
        Point c = new Point(3, -2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        MatcherAssert.assertThat(rsl, closeTo(2, 0.001));
    }
}