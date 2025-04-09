package ru.job4j.tracker.oop;

import ru.job4j.oop.Wolf;

public class Story {
    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Girl girl = new Girl();
        Wolf wolf = new Wolf();
        girl.help(petya);
    }
}