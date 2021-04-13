import java.io.*;
import java.util.*;
import java.math.BigDecimal;

class Quincy
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner sc = new Scanner(new File("quincy.dat"));
        Scanner sc = new Scanner(new File("JudgeData/quincy.dat"));

        while (sc.hasNext())
        {
            HashMap<String, Integer> map1 = new HashMap<String, Integer>();
            HashMap<String, Integer> map2 = new HashMap<String, Integer>();
            HashMap<String, Integer> map3 = new HashMap<String, Integer>();
            String num1 = sc.next();
            BigDecimal num1d = new BigDecimal(num1);
            BigDecimal num2d = num1d.divide(new BigDecimal(String.valueOf(2)));
            String num2 = num2d.toPlainString();
            BigDecimal num3d = num1d.multiply(new BigDecimal(String.valueOf(2)));
            String num3 = num3d.toPlainString();

            for (int i = 0; i < num1.length(); i ++)
            {
                String letter = num1.substring(i, i+1);
                if (letter.equals(".")) continue;
                if (map1.containsKey(letter))
                {
                    map1.put(letter, map1.get(letter)+1);
                } else {
                    map1.put(letter, 1);
                }
            }

            for (int i = 0; i < num2.length(); i ++)
            {
                String letter = num2.substring(i, i+1);
                if (letter.equals(".")) continue;
                if (map2.containsKey(letter))
                {
                    map2.put(letter, map2.get(letter)+1);
                } else {
                    map2.put(letter, 1);
                }
            }

            for (int i = 0; i < num3.length(); i ++)
            {
                String letter = num3.substring(i, i+1);
                if (letter.equals(".")) continue;
                if (map3.containsKey(letter))
                {
                    map3.put(letter, map3.get(letter)+1);
                } else {
                    map3.put(letter, 1);
                }
            }
                System.out.printf("%.60s\n", num1);
                System.out.printf("%.60s\n", num2);
                System.out.printf("%.60s\n", num3);
            for (int i = 0; i <= 9; i++)
            {
                int map1val;
                int map2val;
                int map3val;
                System.out.print(i+" ");
                if (!map1.containsKey(String.valueOf(i))) map1val = 0;
                else map1val = map1.get(String.valueOf(i));
                if (!map2.containsKey(String.valueOf(i))) map2val = 0;
                else map2val = map2.get(String.valueOf(i));
                if (!map3.containsKey(String.valueOf(i))) map3val = 0;
                else map3val = map3.get(String.valueOf(i));


                if (map1val>25)
                {
                    System.out.print(map1val+"*s");
                } else {
                    for (int j = 0; j < map1val; j ++)
                    {
                        System.out.print("*");
                    }
                }
                System.out.print("|");
                if (map2val>25)
                {
                    System.out.print(map2val+"*s");
                } else {
                    for (int j = 0; j < map2val; j ++)
                    {
                        System.out.print("*");
                    }
                }
                System.out.print("|");
                if (map3val>25)
                {
                    System.out.print(map3val+"*s");
                } else {
                    for (int j = 0; j < map3val; j ++)
                    {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}