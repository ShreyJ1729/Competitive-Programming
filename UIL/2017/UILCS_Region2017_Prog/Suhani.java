import java.util.*;
import java.io.*;
import java.lang.Math;

class Suhani
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner sc = new Scanner(new File("suhani.dat"));
        Scanner sc = new Scanner(new File("JudgeData/suhani.dat"));
        while (sc.hasNext())
        {
            double[] t1 = new double[3];
            t1[0] = sc.nextDouble();
            t1[1] = sc.nextDouble();
            t1[2] = sc.nextDouble();

            double[] t2 = new double[3];
            t2[0] = sc.nextDouble();
            t2[1] = sc.nextDouble();
            t2[2] = sc.nextDouble();

            double matches = 0;

            for (int i = 0; i < 3; i ++)
            {
                for (int j = 0; j < 3; j ++)
                {
                    if (t1[i]>0 && t2[j]>0 && t1[i]==t2[j])
                    {
                        matches++;
                        t1[i]=0;
                        t2[j]=0;
                    }
                }
            }

            System.out.println(Math.round(matches));
        }
    }
}
