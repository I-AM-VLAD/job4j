package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void go() {
        boolean driveTenKilometers = true;
    }

    @Override
    public void passengers(int numberOfPassengers) {
        numberOfPassengers = 10;
    }

    @Override
    public int fillUp(int fuelQuantity) {
        fuelQuantity = 10;
        int price = 10;
        return price;
    }
}
