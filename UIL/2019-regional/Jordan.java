import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
class Jordan
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("Region Solutions_dat_out_files/jordan.dat"));
        int n = scanner.nextInt();

        while (scanner.hasNext())
        {
            long first = Long.parseLong(scanner.next(), 17);
            long second = Long.parseLong(scanner.next(), 17);
            long target = Long.parseLong(scanner.next(), 17);
            ArrayList<Long> fib = new ArrayList<Long>();
            fib.add(first);
            fib.add(second);

            boolean stop = false;

            while (!stop)
            {
                fib.add(fib.get(fib.size()-1)+fib.get(fib.size()-2));
                if (fib.get(fib.size()-1)>=target) stop=true;
            }
            if (fib.get(fib.size()-1) == target)
            {
                System.out.println(fib.size());
            } else 
            {
                System.out.println( Long.toString(fib.get(fib.size()-2), 17).toUpperCase() + " " + Long.toString(fib.get(fib.size()-1), 17).toUpperCase());
            }
        }
    }
}