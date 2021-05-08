package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Point2D implements Comparable<Point2D>
{
    public static final Comparator<Point2D> X_ORDER = new XOrder();
    public static final Comparator<Point2D> Y_ORDER = new YOrder();
    public static final Comparator<Point2D> R_ORDER = new ROrder();
    public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
    public final Comparator<Point2D> ATAN2_ORDER = new Atan2Order();
    public final Comparator<Point2D> DISTANCE_TO_ORDER = new DistanceToOrder();

    private final double x; // x coordinate
    private final double y; // y coordinate

    public Point2D(double x, double y)
    {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0)
            x = 0.0; // convert -0.0 to +0.0
        if (y == 0.0)
            y = 0.0; // convert -0.0 to +0.0
        this.x = x;
        this.y = y;
    }

    public double x()
    {
        return x;
    }

    public double y()
    {
        return y;
    }

    public double r()
    {
        return Math.sqrt(x * x + y * y);
    }

    public double theta()
    {
        return Math.atan2(y, x);
    }

    private double angleTo(Point2D that)
    {
        double dx = that.x - this.x;
        double dy = that.y - this.y;
        return Math.atan2(dy, dx);
    }

    public static int ccw(Point2D a, Point2D b, Point2D c)
    {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0)
            return -1;
        else if (area2 > 0)
            return +1;
        else
            return 0;
    }

    public static double area2(Point2D a, Point2D b, Point2D c)
    {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public double distanceTo(Point2D that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distanceSquaredTo(Point2D that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return dx * dx + dy * dy;
    }

    public int compareTo(Point2D that)
    {
        if (this.y < that.y)
            return -1;
        if (this.y > that.y)
            return +1;
        if (this.x < that.x)
            return -1;
        if (this.x > that.x)
            return +1;
        return 0;
    }

    private static class XOrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            if (p.x < q.x)
                return -1;
            if (p.x > q.x)
                return +1;
            return 0;
        }
    }

    private static class YOrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            if (p.y < q.y)
                return -1;
            if (p.y > q.y)
                return +1;
            return 0;
        }
    }

    private static class ROrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            double delta = (p.x * p.x + p.y * p.y) - (q.x * q.x + q.y * q.y);
            if (delta < 0)
                return -1;
            if (delta > 0)
                return +1;
            return 0;
        }
    }

    private class Atan2Order implements Comparator<Point2D>
    {
        public int compare(Point2D q1, Point2D q2)
        {
            double angle1 = angleTo(q1);
            double angle2 = angleTo(q2);
            if (angle1 < angle2)
                return -1;
            else if (angle1 > angle2)
                return +1;
            else
                return 0;
        }
    }

    private class PolarOrder implements Comparator<Point2D>
    {
        public int compare(Point2D q1, Point2D q2)
        {
            double dx1 = q1.x - x;
            double dy1 = q1.y - y;
            double dx2 = q2.x - x;
            double dy2 = q2.y - y;

            if (dy1 >= 0 && dy2 < 0)
                return -1; // q1 above; q2 below
            else if (dy2 >= 0 && dy1 < 0)
                return +1; // q1 below; q2 above
            else if (dy1 == 0 && dy2 == 0)
            { // 3-collinear and horizontal
                if (dx1 >= 0 && dx2 < 0)
                    return -1;
                else if (dx2 >= 0 && dx1 < 0)
                    return +1;
                else
                    return 0;
            } else
                return -ccw(Point2D.this, q1, q2); // both above or below
        }
    }

    private class DistanceToOrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            double dist1 = distanceSquaredTo(p);
            double dist2 = distanceSquaredTo(q);
            if (dist1 < dist2)
                return -1;
            else if (dist1 > dist2)
                return +1;
            else
                return 0;
        }
    }

    public boolean equals(Object other)
    {
        if (other == this)
            return true;
        if (other == null)
            return false;
        if (other.getClass() != this.getClass())
            return false;
        Point2D that = (Point2D) other;
        return this.x == that.x && this.y == that.y;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    public int hashCode()
    {
        int hashX = ((Double) x).hashCode();
        int hashY = ((Double) y).hashCode();
        return 31 * hashX + hashY;
    }

}

class GrahamScan {
    public Stack<Point2D> hull = new Stack<Point2D>();

    public GrahamScan(Point2D[] pts) {

        // defensive copy
        int N = pts.length;
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++)
            points[i] = pts[i];
        Arrays.sort(points);

        Arrays.sort(points, 1, N, points[0].POLAR_ORDER);

        hull.push(points[0]); // p[0] is first extreme point
        int k1;
        for (k1 = 1; k1 < N; k1++)
            if (!points[0].equals(points[k1]))
                break;
        if (k1 == N)
            return; // all points equal

        int k2;
        for (k2 = k1 + 1; k2 < N; k2++)
            if (Point2D.ccw(points[0], points[k1], points[k2]) != 0)
                break;
        hull.push(points[k2 - 1]); // points[k2-1] is second extreme point

        for (int i = k2; i < N; i++) {
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, points[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }

        assert isConvex();
    }

    public Iterable<Point2D> hull() {
        Stack<Point2D> s = new Stack<Point2D>();
        for (Point2D p : hull)
            s.push(p);
        return s;
    }

    private boolean isConvex() {
        int N = hull.size();
        if (N <= 2)
            return true;

        Point2D[] points = new Point2D[N];
        int n = 0;
        for (Point2D p : hull()) {
            points[n++] = p;
        }

        for (int i = 0; i < N; i++) {
            if (Point2D
                    .ccw(points[i], points[(i + 1) % N], points[(i + 2) % N]) <= 0) {
                return false;
            }
        }
        return true;
    }
}
    public class Drgndn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        int[] heigts = new int[n];
        int[] tastiness = new int[n];
        s = br.readLine().split(" ");
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            heigts[i] = Integer.parseInt(s[i]);
            tastiness[i] = Integer.parseInt(temp[i]);
        }
        while (q > 0) {
            q--;
            s = br.readLine().split(" ");
            int curr_query = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            //solving queries
            if (curr_query == 1) {
                //changing tastiness
                tastiness[a + 1] = b;
            }
            else {
                //gliding
                int high = Math.max(a,b);
                int low = Math.min(a,b);
                int count = 0;
                if(high - low == 1){
                    count+= tastiness[high-1]+tastiness[low-1];
                }
                else {
                    Point2D[] points = new Point2D[high - low+3];
                    int j = 0;
                    for(int i = low;i<=high;i++){
                        points[j] = new Point2D(i,heigts[i-1]);
                        j++;
                    }

                    points[j++] = new Point2D(high,0);
                    points[j] = new Point2D(low,0);
                    GrahamScan graham = new GrahamScan(points);
                    ArrayList<Point2D> hull = new ArrayList<>();
                    for (Point2D p : graham.hull()){
                        hull.add(p);
                    }
                    double y1 = 0;
                    int pos1 = 0,pos2 = 0;
                    int i = 0;
                    while(y1==0){
                        y1 = hull.get(i).y();
                        pos1 = i;
                        i++;
                    }
                    i = 0;

                    double y2 = 0;
                    while(y2==0){
                        y2 = hull.get(hull.size()-1-i).y();
                        pos2 = i;
                        i++;
                    }
                    int ans = 0;
                    System.out.println(y1+" "+y2);
                    if(y1<y2){
                        //traverse from last to end
                        double last = hull.get((int)y2).y();
                        for(i = pos2;i>=pos1;i--){
                            double curr = hull.get(i).y();
                            if(curr > last){
                                ans = -1;
                                break;
                            }
                            else{
                                System.out.println(hull.get(i).x()-1);
                                ans += tastiness[(int) hull.get(i).x()-1];
                                last = curr;
                            }
                        }
                    }
                    else{
                        //traverse from start to end
                        double last = hull.get((int)y1).y();
                        for(i = (int) pos1;i>=pos2;i--){
                            System.out.println(i);
                            double curr = hull.get(i).y();
                            if(curr > last){
                                ans = -1;
                                break;
                            }
                            else{
                                System.out.println(hull.get(i).x()-1);
                                ans += tastiness[(int) hull.get(i).x()-1];
                                last = curr;
                            }
                        }
                    }
                   System.out.println(ans);
                }
            }
        }

    }
}
