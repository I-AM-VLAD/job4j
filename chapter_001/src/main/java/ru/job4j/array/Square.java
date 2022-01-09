package ru.job4j.array;

public class Square {
    public double[] calculate(int bound) {
        double[] rst = new double[bound];
        double number = 1;
        for (int i =0; i < bound; i++) {
            rst[i] = Math.pow(number, 2);
            ++number;
        }
        return rst;
    }
}
