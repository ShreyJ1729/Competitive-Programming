import javax.sound.sampled.Line;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dai {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("dai.dat"));
        int n = sc.nextInt(); sc.nextLine();
        while (n --> 0)
        {
            ArrayList<Point> lst = new ArrayList<>();
            String line[] = sc.nextLine().split(" ");
            for (int i = 0; i < line.length - 1; i+=2)
            {
                lst.add(new Point(Integer.parseInt(line[i]),Integer.parseInt(line[i+1]), i/2));
            }
            ArrayList<Line> lines = new ArrayList<>();
            for (int i = 0; i < lst.size(); i+=2)
            {
                lines.add(new Line(lst.get(i),lst.get(i+1)));
            }
            ArrayList<Point> intersectionPoints = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++)
            {
                for (int j = i + 1; j < lines.size(); j++)
                {
                    Point x = Line.intersect(lines.get(i),lines.get(j));
                    intersectionPoints.add(x);
                }
            }

            System.out.println(intersectionPoints);

        }
    }

    static class Line {
        public Point a, b;
        public double slope;
        public double yint;
        public boolean isvert;
        public int index;


        public Line(Point a, Point b)
        {
            this.a=a;
            this.b=b;
            if (a.x==b.x) isvert=true;
            this.slope=(a.y-b.y)/(a.x-b.x+0.0);
            this.yint = b.y-b.x*slope;
            index = a.index;
        }

        public static Point intersect(Line l1, Line l2)
        {
            if (l1.isvert)
            {
                if( (l2.a.x <= l1.a.x && l2.b.x >= l1.a.x) || (l2.a.x >= l1.a.x && l2.b.x <= l1.a.x))
                    return new Point(l1.index, l2.index, 5);
                return new Point(-1,-1,-1);
            } else if (l2.isvert)
            {
                if( (l1.a.x <= l2.a.x && l1.b.x >= l2.a.x) || (l1.a.x >= l2.a.x && l1.b.x <= l2.a.x))
                    return new Point(l1.index, l2.index, 5);
                return new Point(-1,-1,-1);
            }

            double s = l1.slope - l2.slope;
            double z = l2.yint - l1.yint;
            if (s == 0)
            {
                return new Point(-1,-1,0);
            }
            else
            {
                z = z / s;
                double yint3 = l1.slope * z + l1.yint;
                if ((l1.a.y <= yint3 && l1.b.y >= yint3) || (l1.a.y >= yint3 && l1.b.y <= yint3))
                {
                    return new Point (l1.index, l2.index, 5);
                }
            }
            return new Point(-1,-1,0);
        }
    }

    static class Point {
        public double x, y;
        public int index;
        public Point(double a, double b, int index) {
            x = a; y = b; this.index = index;
        }

        public String toString()
        {
            return "("+x+", "+y+")";
        }
    }
}