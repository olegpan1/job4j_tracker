package ru.job4j.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static class Worker {

        private String passport;

        private List<Child> children;

        public Worker(String passport, List<Child> children) {
            this.passport = passport;
            this.children = children;
        }

        public String getPassport() {
            return passport;
        }

        public List<Child> getChildren() {
            return children;
        }
    }

    public static class Child {

        private String name;

        private int age;

        public Child(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static List<Child> defineChildren(List<Worker> workers, String passport) {
        return Example.findByPassport(workers, passport).stream()
                .flatMap(worker -> worker.getChildren().stream())
                .filter(child -> child.getAge() < 15)
                .collect(Collectors.toList());
    }

    public static Optional<Worker> findByPassport(List<Worker> workers, String passport) {
        return workers.stream()
                .filter(w -> w.getPassport().equals(passport))
                .map(worker -> {
                    System.out.println("xxx");
                    if (worker.getPassport().equals(passport)) {
                        return worker;
                    }
                    System.out.println("yyy");

                    return worker;
                })
                .map(worker -> {
                    System.out.println("zzz");
                    return worker;
                })
                .findFirst();
    }

    public static void main(String[] args) {
        String s = Stream.of(1, 2, 3, 4, 5, 6)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(s);
    }
}
