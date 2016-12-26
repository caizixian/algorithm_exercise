import java.util.Scanner;

public class Solution {
    class Point {
        private double x;
        private double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        Point substract(Point other) {
            return new Point(this.x - other.x, this.y - other.y);
        }

        Point addition(Point other) {
            return new Point(this.x + other.x, this.y + other.y);
        }

        Point middle(Point other) {
            return new Point((this.x + other.x) / 2, (this.y + other.y) / 2);
        }

        Point reverse() {
            return new Point(-this.x, -this.y);
        }

        public String toString() {
            return (int) this.x + " " + (int) this.y;
        }
    }

    public static Point oppositePoint(Point diagonalA, Point diagonalB, Point c) {
        Point middle = diagonalA.middle(diagonalB);
        return middle.addition(middle.substract(c));
    }

    public static void main(String[] args) {
        Point[] points = new Point[3];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            points[i] = new Solution().new Point(in.nextInt(), in.nextInt());
        }
        System.out.println(3);
        System.out.println(oppositePoint(points[0], points[1], points[2]));
        System.out.println(oppositePoint(points[0], points[2], points[1]));
        System.out.println(oppositePoint(points[1], points[2], points[0]));
    }
}