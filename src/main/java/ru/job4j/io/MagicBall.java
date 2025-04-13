package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int random = new Random().nextInt(3);
        String answer = switch (random) {
            case 0 -> "Да";
            case 1 -> "Нет";
            case 2 -> "Может быть";
            default -> "";
        };
        System.out.println(answer);
    }
}
