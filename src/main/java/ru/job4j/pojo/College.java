package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Вася Иванов");
        student.setGroupe(213);
        student.setAdmissionDate(LocalDate.of(2021, 9, 1));
        System.out.println("Студент " + student.getName() + " из группы " + student.getGroupe()
               + " Поступил в " + student.getAdmissionDate());
    }
}
