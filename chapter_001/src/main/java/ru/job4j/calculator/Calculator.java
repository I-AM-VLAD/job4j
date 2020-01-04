package ru.job4j.calculator;

/**
 * Calculator.
 * @author Vlad Chupryna (vlad1slaw19982@gmail.com).
 */
public class Calculator
{
    /**
     * Method add.
     * @param first - first.
     * @param second - second.
     */
    public static void add (double first, double second) {
        double result =  first + second;
        System.out.println (first + " + " + second + " = " + result);
    }
    /**
     * Method div.
     * @param first - first.
     * @param second - second.
     */
    public static void div (double first, double second) {
        double result =  first / second;
        System.out.println (first + " / " + second + " = " + result);
    }
    /**
     * Method multiply.
     * @param first - first.
     * @param second - second.
     */
    public static void multiply  (double first, double second) {
        double result =  first * second;
        System.out.println (first + " * " + second + " = " + result);
    }
    /**
     * Method subtract.
     * @param first - first.
     * @param second - second.
     */
    public static void subtract  (double first, double second) {
        double result =  first - second;
        System.out.println (first + " - " + second + " = " + result);
    }

    /**
     * Main.
     * @param args - args.
     */
    public static void main (String [] args) {
        add (1, 1);
        div (4, 2);
        multiply (2, 1);
        subtract (10, 5);
    }
}