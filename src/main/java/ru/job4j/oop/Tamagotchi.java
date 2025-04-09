package ru.job4j.oop;

public class Tamagotchi {
    private int weight = 100;

    public void feed() {
        weight += 10;
    }

    public String info() {
        return "weight: " + weight;
    }

    public static void main(String[] args) {
        Tamagotchi pet = new Tamagotchi();
        Tamagotchi petCopy = pet;
        Tamagotchi pet2 = new Tamagotchi();
        System.out.println(pet.info());
        System.out.println("copy of " + petCopy.info());
        petCopy.feed();
        pet.feed();
        System.out.println(pet.info());
        System.out.println("copy of " + petCopy.info());
        System.out.println(pet.info());
        System.out.println("copy of " + petCopy.info());
        System.out.println(pet2.info());
    }
}