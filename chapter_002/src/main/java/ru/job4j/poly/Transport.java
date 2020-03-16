package ru.job4j.poly;

public interface Transport {
    // ехать
    public void go();
    // пассажиры
    public void passengers(int numberOfPassengers);
    // заправить
    public int fillUp(int fuelQuantity);
}
