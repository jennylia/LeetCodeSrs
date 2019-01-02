package com.company.medium;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Q963_MinimumAreaRec {
    public static void main(String[] args) {
        System.out.println("hello");
        int[][] inputs = {{0, 1}, {1, 2}, {1, 0},{2, 1} };
        double ans = minAreaFreeRect(inputs);
        System.out.println(ans);
    }

    public static double minAreaFreeRect(int[][] points) {
        int N = points.length;
        Point[] allPointsArray = new Point[N];
        Set<Point> allPointsSet = new HashSet<>();

        double minArea = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] pointInput = points[i];
            Point p = new Point(pointInput[0], pointInput[1]);
            allPointsArray[i] = p;
            allPointsSet.add(p);
        }

        for (int i = 0; i < N; i++) {
            Point p1 = allPointsArray[i];
            for (int j = 0; j < N; j++) {
                if (j != i) {
                    Point p2 = allPointsArray[j];
                    for (int k = 0; k < N; k++) {
                        if (k != i && k != j) {
                            Point p3 = allPointsArray[k];

                            // Find p4
                            Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
                            if (allPointsSet.contains(p4)) {
                                // check dot product
                                int dot = (p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y);
                                if (dot == 0) {
                                    double width = p1.distance(p2);
                                    double height = p1.distance(p3);
                                    double area = width * height;
                                    if (area < minArea) {
                                        minArea = area;
                                    }

                                }

                            }
                        }
                    }
                }
            }
        }

        if (minArea == Double.MAX_VALUE) {
            return 0;
        } else {
            return minArea;
        }

    }

    private static boolean isItRectangle(int[][] points) {
        // DOt product is 0 is the best
        Point p1 = new Point(points[0][0], points[0][1]);
        Point p2 = new Point(points[1][0], points[1][1]);
        Point p3 = new Point(points[2][0], points[2][1]);
        Point p4 = new Point(points[3][0], points[3][1]);


        return true;
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

//    public static class Point {
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public double distance(Point p) {
//            //diff in x =
//            int dx = p.x - this.x;
//            int dy = p.y - this.y;
//            double exp = dx * dx + dy * dy;
//            return Math.sqrt(exp);
//        }
//    }
}
