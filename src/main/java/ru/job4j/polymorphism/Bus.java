package ru.job4j.polymorphism;

public class Bus implements Transport {
    private final int passangerCapacity = 120;
    private int passangerCount;
    private final int tankVolume = 200;

    @Override
    public void move() {
        System.out.println("Автобус начал движение!");
    }

    @Override
    public void passengers(int count) {
        if (count < passangerCapacity) {
            passangerCount = count;
        } else {
            System.out.println("Пасажиров меньше чем мест");
        }
    }

    @Override
    public int refuel(int fuel) {
        return (tankVolume - fuel) * 55;
    }
}
