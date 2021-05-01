import java.util.*;
import java.io.*;

public class DryRun {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("dryrun.dat"));

        int num = sc.nextInt();
        for (int i = 0; i < num; i ++)
        {
            System.out.println("I like "+sc.next()+".");
        }
    }
}
