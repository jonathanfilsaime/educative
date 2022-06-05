import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}

class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();
        // TODO: Write your code here

        PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());


        for (int i = 0; i < k; i++) {
            minHeap.add(points[i]);
        }

        for(int y = k; y < points.length; y++) {
            if (!minHeap.isEmpty() && minHeap.peek().distFromOrigin() > new Point(points[y].x, points[y].y).distFromOrigin()) {
                minHeap.remove();
                minHeap.add(points[y]);
            }
        }

        for(int z = 0; z <= minHeap.size(); z++) {
            result.add(minHeap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}