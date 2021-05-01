import java.util.*;
import java.lang.Math;
import java.io.*;

class Maximo
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("maximo.dat");
        Scanner scan = new Scanner(file);

        int num = scan.nextInt();

        for (int i_ = 0; i_ < num; i_ ++)
        {
            HashSet<Integer> a = new HashSet<Integer>();
            HashSet<Integer> b = new HashSet<Integer>();
            HashSet<Integer> c = new HashSet<Integer>();
            ArrayList<Integer> clist = new ArrayList<Integer>();

            String line = scan.next().substring(3);
            line = line.substring(0, line.length()-1);
            String[] nums = line.split(",");

            for (String letter : nums)
            {
                a.add(Integer.parseInt(letter));
            }

            String lineb = scan.next().substring(3);
            lineb = lineb.substring(0, lineb.length()-1);
            String[] numsb = lineb.split(",");

            for (String letter : numsb)
            {
                b.add(Integer.parseInt(letter));
            }

            boolean ahasb = true;
            boolean bhasa = true;

            for (Integer val : a)
            {
                if (b.contains(val))
                {
                    c.add(val);
                }
                else
                {
                    ahasb = false;
                }
            }

            for (Integer val : b)
            {
                if (a.contains(val))
                {
                    c.add(val);
                }
                else
                {
                    bhasa = false;
                }
            }

            for (Integer val : c)
            {
                clist.add(val);
            }

            if (ahasb==false && bhasa==false && clist.size()>0)
            {
                System.out.print("Neither set is a subset of the other. Their intersection is: {");
                for (int idx = 0; idx < clist.size()-1; idx++)
                {
                    System.out.print(clist.get(idx)+",");
                }
                System.out.print(clist.get(clist.size()-1));
                System.out.println("}");
            }

            if (ahasb==false && bhasa==false && clist.size()==0)
            {
                System.out.print("Neither set is a subset of the other. Their intersection is: {}\n");
            }

            if (ahasb && bhasa)
            {
                System.out.println("Set A is equal to Set B");
            }

            if (ahasb && bhasa==false)
            {
                System.out.println("Set A is a subset of Set B");
            }

            if (bhasa && ahasb==false)
            {
                System.out.println("Set B is a subset of Set A");
            }

        }
    }
}