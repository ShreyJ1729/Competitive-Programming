
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kevin {
   public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(new File("kevin.dat"));
       double totalDist = 0;
       double maxDist = 0;
       String totalTime = "00:00:00";
       String maxTime = "00:00:00";
       double fastestPace = Double.MAX_VALUE;

       int shortRunCount = 0;
       double shortRunAvgDist = 0;
       double shortRunAvgPace = 0;

       int mediumRunCount = 0;
       double mediumRunAvgDist = 0;
       double mediumRunAvgPace = 0;

       int longRunCount = 0;
       double longRunAvgDist = 0;
       double longRunAvgPace = 0;

       ArrayList<Jog> kev = new ArrayList<>();
       while (sc.hasNextLine())
       {
           String datee = sc.next();
           double distt = sc.nextDouble();
           boolean shortRun = false;
           boolean mediumRun = false;
           boolean longRun = false;
           if (distt >= 5.0 && distt < 10) {
               shortRun = true;
               shortRunCount++;
               shortRunAvgDist+=distt;
           }
           if (distt >= 10.0 && distt < (42.195/2.0)) {
               mediumRun = true;
               mediumRunCount++;
               mediumRunAvgDist+=distt;
           }
           if (distt >= (42.195/2.0)) {
               longRun = true;
               longRunCount++;
               longRunAvgDist+=distt;
           }

           maxDist = Math.max(distt,maxDist);
           String timee = sc.next(); sc.nextLine();
           String[] totalTimeSplits = timee.split(":");
           int hours = Integer.parseInt(totalTimeSplits[0]);
           int mins = Integer.parseInt(totalTimeSplits[1]);
           int secs = Integer.parseInt(totalTimeSplits[2]);
           double minsDay = hours * 60 + mins + secs/60.0;
           double pace = minsDay/distt;
           fastestPace = Math.min(fastestPace, pace);
           maxTime = timee.compareTo(maxTime) > 0 ? timee : maxTime;
           String[] totalTimeSplit = totalTime.split(":");
           int totalhours = Integer.parseInt(totalTimeSplit[0]);
           int totalmins = Integer.parseInt(totalTimeSplit[1]);
           int totalsecs = Integer.parseInt(totalTimeSplit[2]);
           if (secs + totalsecs > 60) {
               totalmins++;
           }
           totalsecs = (secs + totalsecs) % 60;
           if (totalmins + mins > 60) {
               totalhours++;
           }
           totalmins = (mins + totalmins) % 60;
           totalhours += hours;
           totalTime = totalhours + ":" + totalmins + ":" + totalsecs;

           totalDist += distt;
           kev.add(new Jog(datee, distt, timee));
           //System.out.println(date + " " + dist + " " + time);
       }
       double max7days = 0;
       for (int i = 0; i < kev.size(); i++)
       {
           if (i < kev.size() - 1)
           {
               double max7day = 0;
               for (int j = i; j < i + 7; j++)
                   max7day += kev.get(j).dist;
               max7days = Math.max(max7day, max7days);
           }

       }
       System.out.println("Total distance = " + totalDist);
       System.out.println("Total time = " + totalTime); //not working correctly
       System.out.println("Average distance = " + (totalDist/kev.size()));
       System.out.println("Average time = " + (totalDist/kev.size())); // NEED HELP ON THIS
       System.out.println("Longest distance = " + maxDist);
       System.out.println("Longest time = " + maxTime);
       System.out.println("Fastest pace = " + fastestPace); // need to convert to time
       System.out.println("Short run average distance = " + shortRunAvgDist/shortRunCount);
       System.out.println("Short run average pace = " + shortRunAvgDist/shortRunCount); //needs work
       System.out.println("Medium run average distance = " + mediumRunAvgDist/mediumRunCount);
       System.out.println("Medium run average pace = " + shortRunAvgDist/mediumRunAvgDist); //needs work
       System.out.println("Long run average distance = " + longRunAvgDist/longRunCount);
       System.out.println("Long run average pace = " + shortRunAvgDist/mediumRunAvgDist); // needs work
       System.out.println("Best 7-day streak")







   }

   static class Jog {
       public String date;
       public double dist;
       public String time;

       public Jog(String d, double a, String t)
       {
           date = d;
           dist = a;
           time = t;
       }

   }
}

