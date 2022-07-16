package ru.job4j.oop;

public class Calculator {

    private static int x;

    public static int sum(int a) {
        return a + x;
    }

    public int multiply(int a) {
        return a * x;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        x = 5;

        int result = sum(10);
        System.out.println("sum " + result);

        result = calculator.multiply(10);
        System.out.println("multiply " + result);

        result = minus(10);
        System.out.println("minus " + result);

        result = calculator.divide(10);
        System.out.println("divide " + result);

        result = calculator.sumAllOperation(10);
        System.out.println("sumAllOperation " + result);
    }
}
