import java.util.*;
import java.io.*;

public class Guang
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner scan = new Scanner(new File("guang.dat"));
        Scanner scan = new Scanner(new File("JudgeData/guang.dat"));

        while (scan.hasNext())
        {
            int num = scan.nextInt();
            int base = scan.nextInt();

            String ans = Integer.toString(num, base).toUpperCase();
            // System.out.println(ans.length());
            String ans2 = ans;
            for (int i = 0; i < ans.length(); i ++)
            {
                ans2 = "0"+ans2;
                // System.out.println(ans);
            }

            System.out.println(ans2);
        }
    }
}