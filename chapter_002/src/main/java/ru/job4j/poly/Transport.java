package ru.job4j.poly;

public interface Transport {
    public void go();
    public void passengers(int numberOfPassengers);
    public int fillUp(int fuelQuantity);
}
