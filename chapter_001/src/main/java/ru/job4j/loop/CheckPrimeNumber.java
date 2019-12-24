package ru.job4j.loop;

public class CheckPrimeNumber
{
    public static boolean check (int num)
    {
        /////////////////////////////////
        boolean prime = false;
        /////////////////////////////////
        if ((num % 1) == 0  && (num % num) == 0)
            prime = true;
        /////////////////////////////////
        for (int i = 2; i < num; i++)
            if (num % i == 0 || num == 1)
                prime = false;
        //////////////////////////////////
        return prime;
    }
}
