import java.util.*;
import java.io.*;

public class Leonardo
{
    public static void main(String[] args) throws IOException
    {
        // Scanner scan = new Scanner(new File("leonardo.dat"));
        Scanner scan = new Scanner(new File("JudgeData/leonardo.dat"));

        while (scan.hasNextLine())
        {
            String[] line = scan.nextLine().split(" ");
            String first = "";
            String second = "";
            int partition = 0;
            while (!line[partition].equals("="))
            {
                first += line[partition].charAt(0)+"";
                partition++;
            }
            System.out.print(first);
            for (int i = 1+partition; i < line.length; i ++)
            {
                second += (line[i].charAt(line[i].length()-1)+"").toUpperCase();
            }

            System.out.println(" = " + second);
        }
    }    
}