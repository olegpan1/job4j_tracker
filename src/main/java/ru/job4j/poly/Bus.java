package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    private int passengers = 0;
    private double price = 50;
    private boolean start;

    @Override
    public void go() {
        start = true;
    }

    @Override
    public void countPassengers(int number) {
        passengers += number;
    }

    @Override
    public double fuelCar(double volume) {
        return price * volume;
    }

    @Override
    public void move() {
        System.out.println("The bus is going");
    }
}
