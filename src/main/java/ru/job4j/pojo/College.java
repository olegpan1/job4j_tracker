package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDateOfAdmission("01.09.2020");
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("AA - 07");
        System.out.println("ФИО: " + student.getFio() + " поступил " + student.getDateOfAdmission()
                + " в группу " + student.getGroup());
    }
}
