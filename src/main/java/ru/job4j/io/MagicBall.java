package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String input = scanner.nextLine();
        String out;
        int answer = new Random().nextInt(3);
        if (answer == 0 || answer == 1) {
            out = answer == 0 ? "Да" : "Нет";
        } else {
            out = "Может быть";
        }
        System.out.println(out);
    }
}
