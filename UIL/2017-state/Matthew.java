import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matthew {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("matthew.dat"));
        while (sc.hasNextLine())
        {
            String x[] = sc.nextLine().split(" ");
            int num = sc.nextInt(); sc.nextLine();
            for (int i = 0; i < num; i++)
            {
                String match = sc.nextLine();
                String output = "";
                for (int j = 0; j < x.length; j++)
                {
                    if (x[j].matches(match))
                    {
                        output += x[j] + " ";
                    }
                }
                if (output.length() == 0)
                {
                    System.out.println("NONE");
                }
                else
                    System.out.println(output.substring(0,output.length()-1));
            }
        }

    }
    
}