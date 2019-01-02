package com.company.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q963_MinimumAreaRec {
    public static void main(String[] args) {
        System.out.println("hello");
        int[][] inputs = {{1, 2}, {2, 1}, {1, 0}, {0, 1}};
        double ans = minAreaFreeRect(inputs);
        System.out.println(ans);
    }

    public static double minAreaFreeRect(int[][] points) {

        //TODO
        // isItRectangle()

        return findArea(points);

    }

    private static double findArea(int[][] points) {
        // find the length and width.
        Point p1 = new Point(points[0][0], points[0][1]);
        Point p2 = new Point(points[1][0], points[1][1]);
        Point p3 = new Point(points[2][0], points[2][1]);
        Point p4 = new Point(points[3][0], points[3][1]);

        // find the other points.
//        double d12 =
        double d2 = p1.distance(p2);
        double d3 = p2.distance(p3);
        double d4 = p3.distance(p4);

        List<Double> distances = new ArrayList<>();
        distances.add(d2);
        distances.add(d3);
        distances.add(d4);
        Collections.sort(distances);

        //find the 2 sides
        double side1 = distances.get(0);
        double side2 = distances.get(1);
        return side1 * side2;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Point p) {
            //diff in x =
            int dx = p.x - this.x;
            int dy = p.y - this.y;
            double exp = dx*dx + dy*dy;
            return Math.sqrt(exp);
        }
    }
}
