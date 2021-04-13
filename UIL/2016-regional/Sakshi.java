import java.io.*;
import java.util.*;
import java.lang.*;

class Sakshi
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner sc = new Scanner(new File("sakshi.dat"));
        Scanner sc = new Scanner(new File("JudgeData/sakshi.dat"));
        while (sc.hasNext())
        {
            double base = sc.nextDouble();
            double pow = sc.nextDouble();

            System.out.printf("%.3f\n", Math.pow(base, pow));
        }
    }
}