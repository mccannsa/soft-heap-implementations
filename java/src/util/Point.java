package util;

public class Point implements Comparable<Point> {
    private int x;
    private int y;
    private double angle;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        double degrees = Math.toDegrees(Math.atan2(y, x));
        angle = degrees >= 0 ? degrees : degrees + 360;
    }

    private double distanceFromOrigin() {
        return Math.sqrt((double) (x * x + y * y));
    }

    public int compareTo(Point p) {
        if (angle == p.angle) {
            return (int) (distanceFromOrigin() - p.distanceFromOrigin());
        } else {
            return (int) Math.ceil(angle - p.angle);
        }
    }

    public String toString() {
        return String.format("(%d, %d, %.2f)", x, y, angle);
    }

    public boolean equals(Point p) {
        if (x == p.x && y == p.y) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Point(1, 1));
    }
}
