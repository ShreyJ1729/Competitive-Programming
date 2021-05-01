import java.util.*;
import java.lang.Math;
import java.io.*;

class Olivia
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("olivia.dat");
        Scanner scan = new Scanner(file);

        int num = scan.nextInt();

        for (int i_ = 0; i_ < num; i_ ++)
        {
            HashSet<String> set = new HashSet<String>();
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();

            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i ++)
            {
                for (int j = 0; j < m; j ++)
                {
                    arr[i][j] = (i+1)*(j+1);
                    if (arr[i][j]==k)
                    {
                        set.add(String.valueOf(i1+1+" "+j1+1));
                    }
                }
            }

            for (int i[] : arr)
            {
                System.out.println(Arrays.toString(i));
            }
            System.out.println("LIST: " + set);
            System.out.println("searching " + k);
        }
    }
}