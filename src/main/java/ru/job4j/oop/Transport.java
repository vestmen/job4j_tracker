package ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
        Vehicle firstAirplane = new Airplane();
        Vehicle secondAirplane = new Airplane();
        Vehicle firstTrain = new Train();
        Vehicle secondTrain = new Train();
        Vehicle firstBus = new Bus();
        Vehicle secondBus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{firstAirplane, secondAirplane, firstTrain,
                secondTrain, firstBus, secondBus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
