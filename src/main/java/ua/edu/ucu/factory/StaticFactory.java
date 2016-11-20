package ua.edu.ucu.factory;

class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double r, double theta) {
        // r^2 = x^2 + y^2
        double x = r;
        double y = theta;
        return new Point(x, y);
    }
}

public class StaticFactory {
    public static void main(String[] args) {
        Point p1 = Point.newCartesianPoint(0, 0);
        Point p2 = Point.newPolarPoint(0, 0);
    }
}
