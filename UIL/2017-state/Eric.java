import java.util.*;
import java.io.*;

public class Eric
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner scan = new Scanner(new File("eric.dat"));
        Scanner scan = new Scanner(new File("JudgeData/eric.dat"));

        while (scan.hasNext())
        {
            int first = scan.nextInt();
            int second = scan.nextInt();
            ArrayList<Integer> seq = new ArrayList<Integer>();
            seq.add(first);
            seq.add(second);
            seq.add(first+second%10);
            int count = 1;

            while (seq.get(seq.size()-1)!=second || seq.get(seq.size()-2)!=first)
            {
                int next = (seq.get(seq.size()-1)+seq.get(seq.size()-2))%10;
                seq.add(next);
                count+=1;
            }
            System.out.println(seq.size());
        }
    }
}