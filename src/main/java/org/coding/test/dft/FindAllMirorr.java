package org.coding.test.dft;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindAllMirorr {
    public static class Navigator {
        private int minXPoint;
        private int maxXPoint;
        private int minYPoint;
        private int maxYPoint;

        public static class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }
        }

        public void addGoingPoint(Point currentPoint, Deque<Point> visitablePoints) {


        }
    }

    public static void main(String[] args) {
        int[][] mirro = {
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };


        Navigator.Point currentPoint = new Navigator.Point(0, 0);
        int maxXPoint = mirro.length;
        int maxYPoint = mirro.length;
        Deque<Navigator.Point> visitablePoints = new ArrayDeque<>();
        int[][] going = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
        int currentX = currentPoint.x;
        int currentY = currentPoint.y;

        for (int i = 0; i < going.length; i++) {
            int[] direction = going[i];
            int nextX = currentX + direction[0];
            int nextY = currentY + direction[1];
            // 0, 0
            // up: -1, 0
            // down : 1, 0
            // left : 0, -1
            // right : 0, 1

            if (((nextX >= 0 && nextX < maxYPoint) && (nextY >= 0 && nextY < maxYPoint))
                    && mirro[nextX][nextY] == 0) {
                visitablePoints.add(new Navigator.Point(nextX, nextY));
            }
        }
        visitablePoints.forEach(point -> System.out.println(point.x + " " + point.y));
    }

}
