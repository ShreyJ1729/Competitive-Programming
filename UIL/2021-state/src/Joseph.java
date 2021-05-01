import java.util.*;
import java.io.*;

public class Joseph {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("joseph.dat"));

        TreeMap<String, Integer> first = new TreeMap<String, Integer>();
        TreeMap<String, Integer> second = new TreeMap<String, Integer>();

        TreeMap<String, Integer> diffs = new TreeMap<String, Integer>();

        String[] line = scan.nextLine().split(" ");
        for (String l : line)
        {
            first.put(l, scan.nextInt());
        }
        scan.nextLine();
        String[] line2 = scan.nextLine().split(" ");
        for (String l2 : line2)
        {
            second.put(l2, scan.nextInt());
        }


        for (String p1 : first.keySet())
        {
            for (String p2 : second.keySet())
            {
                String d = p1+" "+p2;
                int diff = Math.abs(first.get(p1)-second.get(p2));
                diffs.put(d, diff);
            }
        }

        TreeSet<String> outputs = new TreeSet<String>();
        for (String key : diffs.keySet())
        {
            outputs.add(diffs.get(key)+" "+key);
        }
//        System.out.println(diffs);
//        System.out.println(outputs);

        for (String val : outputs)
        {
            if (Integer.parseInt(val.split(" ")[0])<10)
                System.out.println(val.split(" ")[1]+" "+val.split(" ")[2]+" "+val.split(" ")[0]);
        }
        for (String val : outputs)
        {
            if (Integer.parseInt(val.split(" ")[0])==10)
                System.out.println(val.split(" ")[1]+" "+val.split(" ")[2]+" "+val.split(" ")[0]);
        }


    }
}
