import java.util.*;
import java.io.*;
import java.lang.Math;

class Rishi
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner sc = new Scanner(new File("rishi.dat"));
        Scanner sc = new Scanner(new File("JudgeData/rishi.dat"));
        
        while (sc.hasNext())
        {
            String word = sc.next();
            boolean encode = true;;

            for (int i = 0; i < word.length(); i ++)
            {
                if (Character.isDigit(word.charAt(i))) encode=false;
            }

            String new_word;
            if (encode)
            {
                new_word = encodeString(word);
            } else {
                new_word = decodeString(word);
            }

            System.out.println(new_word);
        }
    }

    public static String encodeString(String word)
    {
        String ans = "";
        char currl = word.charAt(0);
        int currnum = 1;

        for (int i = 1; i < word.length()-1; i ++)
        {
            char letter = word.charAt(i);
            if (letter==word.charAt(i+1)) currnum++;
            else
            {
                ans+=""+currnum+""+letter;
                currnum=1;
            }

        }

        return ans+""+currnum""+word.charAt(word.length()-1);
    }

    public static String decodeString(String word)
    {
        String ans = "";
        String currnum = "";

        for (int i = 0; i < word.length(); i ++)
        {
            char c = word.charAt(i);
            if (Character.isDigit(c)) currnum+=c;
            else
            {
                for (int j = 0; j < Integer.parseInt(currnum); j ++)
                {
                    ans+=String.valueOf(c);
                }
                currnum="";
            }
        }

        return ans;
    }
}
