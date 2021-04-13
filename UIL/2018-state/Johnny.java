import java.util.*;
import java.io.*;

public class Johnny
{
    public static void main(String[] args) throws IOException
    {
        // Scanner scan = new Scanner(new File("johnny.dat"));
        Scanner scan = new Scanner(new File("JudgeData/johnny.dat"));
        HashMap<String, String> map = new HashMap<String, String>();

        while (scan.hasNextLine())
        {
            String line[] = scan.nextLine().split(" ");

            if (!Character.isLetterOrDigit(line[0].charAt(0)))
            {
                for (String key : line[1].split("/"))
                {
                    map.put(key, line[0]);
                }

                // System.out.println(map);
            }
            else
            {
                for (String word : line)
                {
                    System.out.print(map.get(word));
                }
                System.out.println();
            }
        }
    }    
}