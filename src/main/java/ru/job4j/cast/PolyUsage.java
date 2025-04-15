package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle cityBus = new Bus();
        Vehicle coach = new Bus();
        Vehicle jetPlane = new Plane();
        Vehicle fighter = new Plane();
        Vehicle dieselTrain = new Train();
        Vehicle electricTrain = new Train();
        Vehicle[] vehicles = new Vehicle[]{coach, cityBus, jetPlane, fighter,
        dieselTrain, electricTrain};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }

}
