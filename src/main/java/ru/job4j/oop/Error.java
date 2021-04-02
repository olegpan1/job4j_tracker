package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(System.lineSeparator() + "Error active: " + active);
        System.out.println("Error status: " + status);
        System.out.println("Error message: " + message);
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printInfo();
        Error errorParam1 = new Error(true, 42, "Attention!");
        errorParam1.printInfo();
        Error errorParam2 = new Error(true, 0, "Error!");
        errorParam2.printInfo();
    }
}
