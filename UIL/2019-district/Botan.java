import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
class Botan
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./District Judge dat files/botan.dat");
        Scanner scanner = new Scanner(new File(input.getAbsolutePath()));
        int n = scanner.nextInt();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        for (int i = 1; i < n+1; i ++)
        {
            boolean prime = true;
            String num = String.valueOf(scanner.nextInt());
            for (int j = 0; j < num.length(); j ++)
            {
                if (!primes.contains(Integer.parseInt(num.substring(j, j+1))))
                {
                    prime = false;
                }
            }

            if (prime)
            {
                System.out.println("CASE #"+i+": BOTAN-PRIME");
            } else
            {
                System.out.println("CASE #"+i+": NOT BOTAN-PRIME");
            }
        }
    }
}