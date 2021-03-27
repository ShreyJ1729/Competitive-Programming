import java.util.*;
import java.io.*;
// Isha
class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i ++)
        {
            String first = scanner.next();
            String[] time = scanner.next().split(":");
            String ampm = scanner.next();
            String second = scanner.next();
            int timenum = 3600*Integer.parseInt(time[0]) + 60*Integer.parseInt(time[1]);
            if (ampm.equals("P.M.")) timenum += 12*3600;
            System.out.println(intToTime(timenum));
        }
    }

    public static int timeToInt(String time)
    {
        String[] arr = time.split(":");

        int timenum = 60*Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
        return timenum;
    }

    public static String intToTime(int time)
    {
        int hours = time/3600;
        int mins = time%3600;
        String ampm = "A.M.";
        if (time>12*3600)
        {
            ampm="P.M.";
            hours-=12;
        }
        String minstring = Integer.toString(mins/100);
        // System.out.println(minstring.length());
        String total = minstring;
        if (minstring.length()==1)
        {
            // System.out.println(minstring+"0");
            minstring = minstring+"0";
        }
        String ans = hours+":"+minstring+ " "+ampm;
        return ans;
    }

    public static int getTravelTime(String first, String second)
    {
        if (first.equals("Charlotte"))
        {
            if (second.equals("Houston")) return 2*60+10;
            if (second.equals("Orlando")) return 1*60+29;
            if (second.equals("Denver")) return getTravelTime("Charlotte", "Houston")+getTravelTime("Houston", "Denver");
            if (second.equals("San Diego")) return 4*60+23;
        }
        if (first.equals("Orlando"))
        {
            if (second.equals("Houston")) return 2*60+1;
            if (second.equals("Charlotte")) return 1*60+29;
            if (second.equals("Denver")) return getTravelTime("Orlando", "Houston")+getTravelTime("Houston", "Denver");
            if (second.equals("San Diego")) return getTravelTime("Orlando", "Houston")+getTravelTime("Houston", "San Diego");
        }
        if (first.equals("Houston"))
        {
            if (second.equals("Denver")) return 2*60+5;
            if (second.equals("Charlotte")) return 2*60+10;
            if (second.equals("Orlando")) return 2*60+1;
            if (second.equals("San Diego")) return 2*60+54;
        }
        if (first.equals("Denver"))
        {
            if (second.equals("Houston")) return 2*60+5;
            if (second.equals("Charlotte")) return getTravelTime("Denver", "Houston")+getTravelTime("Houston", "Charlotte");
            if (second.equals("Orlando")) return getTravelTime("Denver", "Houston")+getTravelTime("Houston", "Orlando");
            if (second.equals("San Diego")) return 1*60+59;
        }
        if (first.equals("San Diego"))
        {
            if (second.equals("Houston")) return 2*60+54;
            if (second.equals("Charlotte")) return 4*60+23;
            if (second.equals("Orlando")) return getTravelTime("San Diego", "Houston")+getTravelTime("Houston", "Orlando");
            if (second.equals("Denver")) return 1*60+59;
        }

        return -1;

    }
}