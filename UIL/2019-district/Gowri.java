import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Gowri
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./District Judge dat files/gowri.dat");
        Scanner scanner = new Scanner(new File(input.getAbsolutePath()));
        int num = scanner.nextInt();
        for (int i_ = 0; i_ < num; i_ ++)
        {
            int size = scanner.nextInt();

            //top line
            for (int i = 0; i < 4; i ++)
            {
                System.out.print(" ");
            }
            for (int i = 0; i < size; i ++)
            {
                System.out.print("*");
            }
            System.out.println();

            //fattening part
            for (int i = 0; i < 3; i ++) System.out.print(" ");
            System.out.print("*");
            for (int i = 0; i < size; i ++) System.out.print(" ");
            System.out.print("*");

            System.out.println();

            for (int i = 0; i < 2; i ++) System.out.print(" ");
            System.out.print("*");
            for (int i = 0; i < size+2; i ++) System.out.print(" ");
            System.out.print("*");

            System.out.println();

            for (int i = 0; i < 1; i ++) System.out.print(" ");
            System.out.print("*");
            for (int i = 0; i < size+4; i ++) System.out.print(" ");
            System.out.print("*");
            
            System.out.println();

            // vertical part
            for (int i = 0; i < size; i ++)
            {
                System.out.print("*");
                for (int j = 0; j < size+3*2; j ++) System.out.print(" ");
                System.out.print("*");
                System.out.println();
            }

            //fattening part
   
            for (int i = 0; i < 1; i ++) System.out.print(" ");
            System.out.print("*");
            for (int i = 0; i < size+4; i ++) System.out.print(" ");
            System.out.print("*");
            
            System.out.println();
  
            for (int i = 0; i < 2; i ++) System.out.print(" ");
            System.out.print("*");
            for (int i = 0; i < size+2; i ++) System.out.print(" ");
            System.out.print("*");

            System.out.println();          
                     for (int i = 0; i < 3; i ++) System.out.print(" ");
            System.out.print("*");
            for (int i = 0; i < size; i ++) System.out.print(" ");
            System.out.print("*");

            System.out.println();


            //top line
            for (int i = 0; i < 4; i ++)
            {
                System.out.print(" ");
            }
            for (int i = 0; i < size; i ++)
            {
                System.out.print("*");
            }

            System.out.println("\n--------------------");
        }
    }
}