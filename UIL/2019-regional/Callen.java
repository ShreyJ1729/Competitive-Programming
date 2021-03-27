import java.io.*;
import java.util.*;

public class Callen
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("Region Solutions_dat_out_files/callen.dat"));
        while (sc.hasNext())
        {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            int step = sc.nextInt();
            int wind1 = sc.nextInt();
            int wind2 = sc.nextInt();
            int step2 = sc.nextInt();
            // System.out.println(temp1 + " " +  temp2 +  " " + step +  " "+ wind1 + " " +  wind2 + " " + step2);
            int numSteps = Math.abs(temp1 - temp2) / step;
            boolean lessThan = temp1 > temp2;
			if (temp1 > temp2) {int temp = temp1;temp1 = temp2;temp2 = temp;}
			if (wind2 < wind1) {
				int wind = wind1;
				wind1 = wind2;
				wind2 = wind;
			}
            System.out.println("       Wind Speeds");
			System.out.print("  Temps");
            for (int i = wind1; i <= wind2; i += step2)
				System.out.printf("%7s", i);
			System.out.println();
            
            for (int i = temp1; i <= temp2; i+=step)
            {
                System.out.printf("%7d", i);
                for (int j = wind1; j <= wind2; j+=step2)
                {
                    double f = 35.74 + 0.6215 * i - (35.75 * Math.pow(j, 0.16)) + (0.4275 * i * Math.pow(j, 0.16));
                    System.out.printf("%7.1f", f);
                }
                System.out.println();
            }
            System.out.println("*********");
        }
    }
}