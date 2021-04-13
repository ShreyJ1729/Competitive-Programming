import java.util.*;
import java.io.*;
import java.lang.Math;

class Lisa
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner sc = new Scanner(new File("lisa.dat"));
        Scanner sc = new Scanner(new File("JudgeData/lisa.dat"));
        TreeMap<Double, String> avg2name = new TreeMap<Double, String>(Collections.reverseOrder());
        HashMap<String, Double[]> data = new HashMap<String, Double[]>();

        while (sc.hasNext())
        {
            String word = sc.next();
            String wordu = word.toUpperCase();
            String wordl = word.toLowerCase();

            int first = 0;
            int second = 0;
            int third = 0;

            for (int i = 0; i < word.length(); i ++)
            {
                char c = word.charAt(i);
                first += (int)c;
            }
            for (int i = 0; i < wordu.length(); i ++)
            {
                char c = wordu.charAt(i);
                second += (int)c;
            }
            for (int i = 0; i < wordl.length(); i ++)
            {
                char c = wordl.charAt(i);
                third += (int)c;
            }

            double avg = (first+second+third)/(3.0*word.length());
            avg2name.put(avg, word);
            data.put(word, new Double[]{(double)first, (double)second, (double)third});
        }

        for (Double avg : avg2name.keySet())
        {
            String word = avg2name.get(avg);
            Double[] nums = data.get(word);

            int space = 10-word.length();

            System.out.print(word);
            for (int i = 0; i < space; i ++)
            {
                System.out.print(" ");
            }
            double first = Math.round(nums[0]);
            double second = Math.round(nums[1]);
            double third = Math.round(nums[2]);
            
            System.out.printf(" %4.0f %4.0f %4.0f %4.2f\n", first, second, third, avg);
        }
    }
}
