import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

class Kenneth
{
    public static boolean isSeqOk(int[] seq)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : seq)
        {
            set.add(i);
        }
        if (set.size() != 9) return false;
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./District2020 JudgeDataFiles/kenneth.dat");
        Scanner scanner = new Scanner(input);
        int num = scanner.nextInt();

        for (int i = 1; i < num+1; i ++)
        {
            boolean bad = false;
            ArrayList<Integer> errorRows = new ArrayList<Integer>();
            ArrayList<Integer> errorColumns = new ArrayList<Integer>();
            int[][] sudoku = new int[9][9];
            //populate board
            for (int r = 0; r < 9; r ++)
            {
                for (int c = 0; c < 9; c ++)
                {
                    sudoku[r][c] = scanner.nextInt();
                }
            }
            // //print sudoku
            // for (int[] r : sudoku)
            // {
            //     for (int v : r)
            //         System.out.print(v+" ");
            //     System.out.println();        
            // }


            // Check each row
            for (int r = 0; r < 9; r ++)
            {
                if (!isSeqOk(sudoku[r]))
                {
                    errorRows.add(r+1);
                    bad = true;
                }
            }


            // Check each column
            for (int c = 0; c < 9; c ++)
            {
                int[] column = new int[9];
                for (int r = 0; r < 9; r ++)
                {
                    column[r] = sudoku[r][c];
                }
                if (!isSeqOk(column))
                {
                    errorColumns.add(c+1);
                    bad = true;
                }
            }

            if (bad)
            {
                System.out.println("GRID #"+i+": NOT A SOLUTION");
                System.out.print(">> ROWS WITH ERRORS: ");
                if (errorRows.size()==0) System.out.print("NONE");
                else
                {
                    for (int k : errorRows) System.out.print(k+" ");
                }
                System.out.println();
                System.out.print(">> COLUMNS WITH ERRORS: ");
                if (errorColumns.size()==0) System.out.print("NONE");
                else
                {
                    for (int k : errorColumns) System.out.print(k+" ");
                }
            }
            else
            {
                System.out.print("GRID #"+i+": SOLUTION IS CORRECT");
            }
            System.out.println("\n============");
        }
    }
}