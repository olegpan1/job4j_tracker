package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.name + " съел " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Гав");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Черный");
        black.eat("fish");
        black.show();
    }
}