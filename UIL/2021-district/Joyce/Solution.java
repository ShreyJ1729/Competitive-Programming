import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int k_ = 0; k_ < num; k_ ++)
        {
            String line = scanner.nextLine().replaceAll(" ", "");
            // System.out.println(line);
            HashSet<String> set = new HashSet<String>();
            ArrayList<String> list = new ArrayList<String>();
            TreeSet<String> alphas = new TreeSet<String>();

            alphas.add("a");
            alphas.add("b");
            alphas.add("c");
            alphas.add("d");
            alphas.add("e");
            alphas.add("f");
            alphas.add("g");
            alphas.add("h");
            alphas.add("i");
            alphas.add("j");
            alphas.add("k");
            alphas.add("l");
            alphas.add("m");
            alphas.add("n");
            alphas.add("o");
            alphas.add("p");
            alphas.add("q");
            alphas.add("r");
            alphas.add("s");
            alphas.add("t");
            alphas.add("u");
            alphas.add("v");
            alphas.add("w");
            alphas.add("x");
            alphas.add("y");
            alphas.add("z");

            for (int i=0; i<line.length(); i ++)
            {
                String letter = line.substring(i, i+1).toLowerCase();
                char character = line.charAt(i);
                if (Character.isLetter(character))
                {
                    set.add(letter);
                    list.add(letter);
                    alphas.remove(letter);
                }
            }
            // System.out.println("letters: " + set);
            // System.out.println("all: " + list);

            if (set.size() == list.size() && alphas.size()==0)
            {
                System.out.println("perfect pangram");
            } else if (set.size()<list.size() && alphas.size()==0)
            {
                System.out.println("pangram");                
            }
            else
            {
                System.out.print("missing ");
                for (String el : alphas)
                {
                    System.out.print(el);
                }
                System.out.println();
            }
        }
    }
}