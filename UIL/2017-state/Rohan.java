import java.util.*;
import java.io.*;
import java.lang.Math;

public class Rohan
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner scan = new Scanner(new File("rohan.dat"));
        Scanner scan = new Scanner(new File("JudgeData/rohan.dat"));

        while (scan.hasNext())
        {
            double xa = scan.nextDouble();
            double ya = scan.nextDouble();
            double xb = scan.nextDouble();
            double yb = scan.nextDouble();
            double xc = scan.nextDouble();
            double yc = scan.nextDouble();

            double a = dist(xb, yb, xc, yc);
            double b = dist(xa, ya, xc, yc);
            double c = dist(xa, ya, xb, yb);

            System.out.printf("(%.2f,%.2f)\n", incenter(a, b, c, xa, xb, xc), incenter(a, b, c, ya, yb, yc));
            System.out.printf("(%.2f,%.2f)\n", centroid(xa, xb, xc), centroid(ya, yb, yc));
            System.out.printf("%.2f\n", area(a, b, c));
        }
    }

    static double area(double a, double b, double c)
    {
        double s = (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    static double centroid(double xa, double xb, double xc)
    {
        return (xa+xb+xc)/3.0;
    }

    static double incenter(double a, double b, double c, double ya, double yb, double yc)
    {
        return (a*ya + b*yb + c*yc)/(0.0+a+b+c);
    }

    static double dist(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
}