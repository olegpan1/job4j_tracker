package  ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void testDistance1() {
        Point a = new Point(-2, 4);
        Point b = new Point(5, -3);
        double dist = a.distance(b);
        double expected = 9.899;
        Assert.assertEquals(expected, dist, 0.001);
    }

    @Test
    public void testDistance2() {
        Point a = new Point(-3, 2);
        Point b = new Point(7, 2);
        double dist = a.distance(b);
        double expected = 10;
        Assert.assertEquals(expected, dist, 0.001);
    }

    @Test
    public void testDistance3() {
        Point a = new Point(6, 1);
        Point b = new Point(6, 4);
        double dist = a.distance(b);
        double expected = 3;
        Assert.assertEquals(expected, dist, 0.001);
    }

    @Test
    public void testDistance4() {
        Point a = new Point(-3, -3);
        Point b = new Point(5, 5);
        double dist = a.distance(b);
        double expected = 11.314;
        Assert.assertEquals(expected, dist, 0.001);
    }

    @Test
    public void testDistance5() {
        Point a = new Point(1, -3);
        Point b = new Point(3, 4);
        double dist = a.distance(b);
        double expected = 7.280;
        Assert.assertEquals(expected, dist, 0.001);
    }

}