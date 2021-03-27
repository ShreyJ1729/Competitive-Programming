import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        int num = scanner.nextInt();
        for (int k = 0; k < num; k ++)
        {
            String[][] board = new String[5][5];
            for (int i = 0; i < 5; i ++)
            {
                String[] line = scanner.next().split("");
                board[i] = line;
            }

            // for (String[] i : board)
            // {
            //     for (String j : i)
            //         System.out.print(j);
            //     System.out.println();
            // }
            int count = 0;

            boolean status = true;

            for (int i = 0; i < 5; i ++)
            {
                for (int j = 0; j < 5; j ++)
                {
                    if (board[i][j].equals("a"))
                    {
                        count+=1;
                        if (i+2<5 && j+2<5 && board[i+2][j+2].equals("a")) status=false;
                        if (i+2<5 && j-2>=0 && board[i+2][j-2].equals("a")) status=false;
                        if (i-2>=0 && j+2<5 && board[i-2][j+2].equals("a")) status=false;
                        if (i-2>=0 && j-2>=0 && board[i-2][j-2].equals("a")) status=false;
                    }
                }
            }

            
            if (status && (count==9)) System.out.println("valid");
            else System.out.println("invalid");
            scanner.next();
        }
    }
}