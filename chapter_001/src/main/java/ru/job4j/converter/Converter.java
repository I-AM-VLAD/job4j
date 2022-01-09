package ru.job4j.converter;

public class Converter
{

    public static int rubleToEuro (int value)
    {
        return value / 70;
    }

    public static int rubleToDollar (int value)
    {
        return value / 60;
    }

    public static int euroToRuble (int value)
    {
        return value * 70;
    }

    public static int dollarToRuble (int value)
    {
        return value * 60;
    }

    public static void main (String [] args)
    {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro (in);
        boolean passed = expected == out;
        System.out.println ("140 rubles are 2 euro. Test result : " + passed);
        int in1 = 180;
        int expected1 = 2;
        int out1 = rubleToDollar (in1);
        boolean passed1 = expected1 == out1;
        System.out.println ("180 rubles are 3 dollars. Test result : " + passed1);
        int in3 = 2;
        int expected3 = 140;
        int out3 = euroToRuble (in3);
        boolean passed3 = expected3 == out3;
        System.out.println ("2 euro are 140 rubles. Test result : " + passed3);
        int in4 = 3;
        int expected4 = 180;
        int out4 = dollarToRuble (in4);
        boolean passed4 = expected4 == out4;
        System.out.println ("3 dollars are 180 rubles. Test result : " + passed4);
    }
}
