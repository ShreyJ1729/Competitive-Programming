import java.util.*;
import java.lang.Math;
import java.io.*;

class dryrun
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("dryrun.dat");
        Scanner scan = new Scanner(file);

        int num = scan.nextInt();

        for (int i = 0; i < num; i ++)
        {
            System.out.println("I like " + scan.next()+".");
        }
    }
}