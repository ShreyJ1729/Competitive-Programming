import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
class Lucie
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("Region Solutions_dat_out_files/lucie.dat"));
        int n = scanner.nextInt();

        while (scanner.hasNext())
        {
            String[] firstline = scanner.next().split(",");
            int t = Integer.parseInt(firstline[0]);
            int p = Integer.parseInt(firstline[1]);

            int[][] first = new int[t][p];
            
            for (int i = 0; i < t; i ++)
            {
                String[] row = scanner.next().split(",");
                for (int j = 0; j < p; j ++)
                {
                    first[i][j] = Integer.parseInt(row[j]);
                }
            }

            int[][] second = new int[p][t+1];
            // transpose
            for (int i = 0; i < first.length; i ++)
            {
                for (int j=0; j < first[0].length; j ++)
                {
                    second[j][i] = first[i][j];
                }
            }

            // get sums
            for (int row=0; row<second.length; row++)
            {
                int sum = 0;
                for (int el=0; el<second[0].length; el++)
                {
                    sum+=second[row][el];
                }
                second[row][t] = sum;
            }
            
            //print
            for (int[] i : second)
            {
                for (int j : i)
                {
                    System.out.print(j+",");
                }
            System.out.println();
            }
        System.out.println("***********");
        }
    }
}