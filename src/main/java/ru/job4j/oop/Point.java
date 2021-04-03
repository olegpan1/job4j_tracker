package ru.job4j.oop;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public double distance3D(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }

    public static void main(String[] args) {
        Point a2D = new Point(0, 0);
        Point b2D = new Point(0, 2);
        double dist2D = a2D.distance(b2D);
        System.out.println("Distance 2D = " + dist2D);
        Point a3D = new Point(0, 0, 0);
        Point b3D = new Point(0, 2, 3);
        double dist3D = a3D.distance3D(b3D);
        System.out.println("Distance 3D = " + dist3D);
    }
}