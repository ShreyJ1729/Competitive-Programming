import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.Iterator;
class Egor
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./District Judge dat files/egor.dat");
        Scanner scanner = new Scanner(new File(input.getAbsolutePath()));
        int num = scanner.nextInt();
        TreeSet<String> names = new TreeSet<String>();
        for (int i = 0; i < num; i ++)
        {
            String name = scanner.next().toLowerCase();
            //check basic things
            if (name.length()<=8 && !name.contains("ph") && !name.contains("c") && !name.contains("m") && !name.contains("o") && !name.contains("y") && name.length()>=5)
            {
                //check first letter is from first half of alphabet
                if (name.charAt(0)<=109)
                {
                    names.add(name);
                }

            }
        }
        Iterator it = names.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}