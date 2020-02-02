package ru.job4j.condition;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point a, Point b, Point c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            return Math.sqrt (p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    private boolean exist(double ab, double ac, double bc) {
        if ((ab + ac > bc) && (ac + bc > ab) && (ab + bc > ac)) {
            return true;
        } else {
            return false;
        }
    }
}


