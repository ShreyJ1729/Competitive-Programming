import java.util.*;
import java.io.*;
import java.lang.Math;

public class Konstantinos
{
    public static void main(String[] args) throws IOException
    {
        // Scanner scan = new Scanner(new File("konstantinos.dat"));
        Scanner scan = new Scanner(new File("JudgeData/konstantinos.dat"));

        while (scan.hasNext())
        {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int r1 = scan.nextInt();

            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int r2 = scan.nextInt();

            double centerDistance = dist(x1, y1, x2, y2);
            // if distance between centers is more than sum of radii --> non instersecting
            if (centerDistance > r1+r2)
            {
                System.out.println("NON-INTERSECTING");
            }
            // else if distance between centers == sum of radii --> externally tangent
            else if (centerDistance == r1+r2)
            {
                System.out.println("EXTERNALLY TANGENT");
            }
            // else if distance between centers is equal to abs(r1-r2) --> internally tangent
            else if (centerDistance == Math.abs(r1-r2))
            {
                System.out.println("INTERNALLY TANGENT");
            }
            // else if distance between centers is less than abs(r1-r2) --> nested
            else if (centerDistance < Math.abs(r1-r2))
            {
                System.out.println("NESTED");
            }
            // else intersecting
            else
            {
                System.out.println("INTERSECTING");
            }
        }
    }

    static double dist(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
}