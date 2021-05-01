import java.util.*;
import java.io.*;

public class Khushi {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("khushi.dat"));
        int num = scan.nextInt();

        for (int i_=0;i_<num;i_++)
        {
            double first = scan.nextDouble()*100;
            double second = scan.nextDouble()*100;

            int[] values = new int[]{2000, 1000, 500, 100, 25, 10, 5, 1};
            String[] names = new String[]{"$20", "$10", "$5", "$1", "Quarter", "Dime", "Nickel", "Penny"};
            String[] pnames = new String[]{"$20", "$10", "$5", "$1", "Quarters", "Dimes", "Nickels", "Pennies"};
            int[] counts = new int[]      {0,    0,    0,   0,   0,    0,   0 ,   0};

            int change = (int)(second-first);
            System.out.println(first+" " + second+ " "+change);
            if (change==0)
            {
                System.out.println("No Change Owed");
            }
            else
            {
                int i = 0;
                while (i<8)
                {
                    while (change>=values[i])
                    {
                        change-=values[i];
                        counts[i]++;
                    }
                    i++;
                }

                //print answer
                for (int idx = 0; idx<counts.length; idx++)
                {
                    int val = counts[idx];
                    if (val==1)
                    {
                        System.out.print(val+"-"+names[idx]+" ");
                    }
                    else if (val>1)
                    {
                        System.out.print(val+"-"+pnames[idx]+" ");
                    }
                }
                System.out.println();
//                System.out.println(change);
            }
        }
    }
}
