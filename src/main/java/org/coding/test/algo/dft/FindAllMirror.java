package org.coding.test.algo.dft;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindAllMirror {
    public static class Navigator {
        public final int[][] mirror;
        private final int maxXPoint;
        private final int maxYPoint;

        public Navigator(int[][] mirror) {
            this.mirror = mirror;
            this.maxXPoint = mirror.length;
            this.maxYPoint = mirror[0].length;
        }

        public static class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point prevPoint = (Point) o;
                return x == prevPoint.x && y == prevPoint.y;
            }
        }

        private void visited(Point currentPoint, Deque<Point> visitedPoints) {
            int currentX = currentPoint.x;
            int currentY = currentPoint.y;
            visitedPoints.push(currentPoint);
            this.mirror[currentX][currentY] = 2;
        }

        private void pathSearch(Point currentPoint, Deque<Point> visitablePoints, Deque<Point> visitedPoints) {
            int currentX = currentPoint.x;
            int currentY = currentPoint.y;

            // 현재 경로에서 갈 수 있는 모든 경로를 스택에 추가
            int[][] going = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
            for (int i = 0; i < going.length; i++) {
                int[] direction = going[i];
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                // 0, 0
                // up: -1, 0
                // down : 1, 0
                // left : 0, -1
                // right : 0, 1

                if (((nextX >= 0 && nextX < maxXPoint) && (nextY >= 0 && nextY < maxYPoint))
                        && !visitedPoints.contains(new Point(nextX, nextY))
                        && mirror[nextX][nextY] != 1) {
                    visitablePoints.push(new Navigator.Point(nextX, nextY));
                }
            }
        }

        private boolean isDeadEnd(Deque<Point> visitablePoints, Point currentPoint) {
            return visitablePoints.isEmpty() && !(currentPoint.x == mirror.length - 1 && currentPoint.y == mirror.length - 1);
        }

        private boolean hasRevisitingOn(Deque<Point> visitedPoints) {
            return visitedPoints.size() != visitedPoints.stream().distinct().count();
        }

        public void findWay(Point currentPoint, Deque<Point> visitedPoints) {
            int currentX = currentPoint.x;
            int currentY = currentPoint.y;
            Deque<Point> visitablePoints = new ArrayDeque<>();

            if (visitedPoints.contains(currentPoint))
                return;
            visited(currentPoint, visitedPoints);
            pathSearch(currentPoint, visitablePoints, visitedPoints);
            if (hasRevisitingOn(visitedPoints))
                return;

            if (isDeadEnd(visitablePoints, currentPoint)) {
                visitedPoints.pop();
//                mirror[currentX][currentY] = 3;
                return;
            }

            if (currentPoint.x == mirror.length - 1 && currentPoint.y == mirror.length - 1) {
                System.out.println("Find one's way");
                visitedPoints.forEach(point -> System.out.println(point.x + ", " + point.y + " "));
                System.out.println("--------------");
                visitedPoints.pop();
                return;
            }

            Point nextPoint = visitablePoints.pop();
            // 이미 방문한 적이 있는 곳이라면 종료
            //if (visitedPoints.contains(nextPoint))
            //    return;

            // 그렇지 않다면, 탐색
            findWay(nextPoint, visitedPoints);

            // 재귀 함수 호출 종료 후,
            // 스택이 비어 있는 상태가 아니라면 다시 진행
            if (!visitablePoints.isEmpty()) {
                findWay(visitablePoints.pop(), visitedPoints);
                visitedPoints.pop();
            } else {
                visitedPoints.pop();
            }
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
        Navigator navigator = new Navigator(mirro);
        Navigator.Point currentPoint = new Navigator.Point(0, 0);
        Deque<Navigator.Point> visitedPoints = new ArrayDeque<>();
        navigator.findWay(currentPoint, visitedPoints);
    }

}
