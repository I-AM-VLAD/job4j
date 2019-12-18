package ru.job4j.condition;

public class MultiMax
{
    public int max (int first, int second, int third)
    {
        int max1 = first >= second ? first : second;
        int result = max1 >= third ? max1 : third;
        return result;
    }
}
