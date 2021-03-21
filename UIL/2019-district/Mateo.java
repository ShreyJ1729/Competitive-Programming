import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Mateo
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./9.in");
        Scanner scanner = new Scanner(new File(input.getAbsolutePath()));
        while (scanner.hasNext())
        {
            double[] sols = {-4.5337925540637, -2.0804001131657, 1.4040871210463, 5.2101055461832};
            double first = scanner.nextDouble();
            double second = scanner.nextDouble();
            double f1 = f(first);
            double f2 = f(second);

            if (Math.signum(f1)==Math.signum(f2))
            {
                System.out.println("UNKNOWN");
            } else
            {
                for (double i : sols)
                {
                    if ((first<i && i<second) || (second<i && i<first))
                    {
                        System.out.println(Math.round(i * 10000000)/10000000.0);
                    }
                }
            }
        }
    }
        public static double f(double x)
    {
        return 1.3*x*x*x*x - 35.1*x*x - 18.2*x + 89.7;
    }
}