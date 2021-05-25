package ru.job4j.stream;

public class Auto {
    private String model;
    private int power;
    private int yearOfMan;
    private String vin;
    private String color;
    private String engine;

    @Override
    public String toString() {
        return "Auto{"
                + "model = " + model
                + ", power = " + power
                + ", yearOfMan = " + yearOfMan
                + ", vin = " + vin
                + ", color = " + color
                + ", engine = " + engine
                + '}';
    }

    static class Builder {
        private String model;
        private int power;
        private int yearOfMan;
        private String vin;
        private String color;
        private String engine;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildPower(int power) {
            this.power = power;
            return this;
        }

        Builder buildYearOfMan(int yearOfMan) {
            this.yearOfMan = yearOfMan;
            return this;
        }

        Builder buildVin(String vin) {
            this.vin = vin;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildEngine(String engine) {
            this.engine = engine;
            return this;
        }

        Auto build() {
            Auto auto = new Auto();
            auto.model = model;
            auto.power = power;
            auto.yearOfMan = yearOfMan;
            auto.vin = vin;
            auto.color = color;
            auto.engine = engine;
            return auto;
        }
    }

    public static void main(String[] args) {
        Auto auto = new Builder()
                .buildModel("BMW")
                .buildPower(500)
                .buildYearOfMan(2021)
                .buildVin("XXX3345566VVV")
                .buildColor("Red")
                .buildEngine("V5")
                .build();
        System.out.println(auto);
    }
}
