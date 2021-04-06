package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        int count = 11;
        boolean turn = true;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            int availability = count < 3 ? count : 3;
            System.out.println(player + " ведите количество спичек от 1 до " + availability);
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 0 && matches < 4 && matches <= count) {
                count -= matches;
                turn = !turn;
                System.out.println("На столе осталось:  " + count + " спичек.");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок!");
        }
    }
}
