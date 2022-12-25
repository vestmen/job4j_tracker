package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passenger(int passengers) {
        System.out.println("В автобусе едет " + passengers + " пассажиров");
    }

    @Override
    public double price(int fuel) {
        return 49.9 * fuel;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.go();
        bus.passenger(18);
        bus.price(25);
    }
}
