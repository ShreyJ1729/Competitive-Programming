import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        int num = scanner.nextInt();
        for (int k_ = 0; k_ < num; k_ ++)
        {
            int in = scanner.nextInt();
            System.out.println(in + " -> " + digitProd(String.valueOf(in)));
        }
    }


    public static int digitProd(String num)
    {
        if (num.length()==1) return Integer.parseInt(num);

        int prod = 1;

        for (int i = 0; i < num.length(); i ++)
        {
            if (!num.substring(i, i+1).equals("0"))
            prod*=Integer.parseInt(num.substring(i, i+1));
        }
        return digitProd(String.valueOf(prod));
    }
}