package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(60);
        Battery second = new Battery(39);
        System.out.println("Before : first - " + first.load + " %, second - " + second.load + " %");
        first.exchange(second);
        System.out.println("After  : first - " + first.load + " %, second - " + second.load + " %");
    }
}
