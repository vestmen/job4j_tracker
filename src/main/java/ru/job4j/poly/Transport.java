package ru.job4j.poly;

public interface Transport {
    void go();

    void passenger(int passengers);

    double price(int fuel);
}
