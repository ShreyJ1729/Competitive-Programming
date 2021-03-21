import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.io.File;

class Josefa
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./District2020 JudgeDataFiles/josefa.dat");
        Scanner scanner = new Scanner(input);
        int num = scanner.nextInt();

        for (int g_ = 0; g_ < num; g_ ++)
        {
            int number = scanner.nextInt();
            String binary = Integer.toBinaryString(number);
            if (binary.length()>8) binary = binary.substring(binary.length()-8, binary.length());
            if (binary.length()<8)
            {
                while (binary.length()<8)
                {
                    binary = "0"+binary;
                }
            }
            System.out.println(number + " = " + binary);
        }
    }
}