import java.util.*;
import java.io.*;
import java.lang.Math;

public class Romero
{
    public static void main(String[] args) throws IOException
    {
        // Scanner scan = new Scanner(new File("romero.dat"));
        Scanner scan = new Scanner(new File("JudgeData/romero.dat"));
        int num = scan.nextInt();

        System.out.println("Date               Attendance Gross      ATP   STP   Adults Stu/Child|");
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"};

        for (int i_ = 0; i_ < num; i_ ++)
        {
            String[] Date = scan.next().split("/");
            int Attendance = scan.nextInt();
            double Gross = scan.nextDouble();
            double ATP = scan.nextDouble();
            double STP = scan.nextDouble();

            int Adults = (int) Math.round( (Gross - STP*Attendance) / (ATP - STP) );
            int Kids = (int) Math.round( (Gross - ATP*Adults)/STP );
            String DateString = String.format("%s %d, %d", months[Integer.parseInt(Date[0])], Integer.parseInt(Date[1]), Integer.parseInt(Date[2]));
            System.out.print(DateString);

            for (int i = 0; i < 19-DateString.length(); i ++)
            {
                System.out.print(" ");
            }

            String AttendanceString = String.format("%d", Attendance);
            System.out.print(AttendanceString);

            for (int i = 0; i < 11-AttendanceString.length(); i ++)
            {
                System.out.print(" ");
            }

            String GrossString = String.format("$%,.2f", Gross);
            System.out.print(GrossString);

            for (int i = 0; i < 11-GrossString.length(); i ++)
            {
                System.out.print(" ");
            }
            
            String ATPString = String.format("$%.2f", ATP);
            System.out.print(ATPString);

            for (int i = 0; i < 6-ATPString.length(); i ++)
            {
                System.out.print(" ");
            }

            String STPString = String.format("$%.2f", STP);
            System.out.print(STPString);

            for (int i = 0; i < 6-STPString.length(); i ++)
            {
                System.out.print(" ");
            }

            String AdultString = String.format("%d", Adults);
            System.out.print(AdultString);

            for (int i = 0; i < 7-AdultString.length(); i ++)
            {
                System.out.print(" ");
            }

            String KidString = String.format("%d", Kids);
            System.out.print(KidString);

            for (int i = 0; i < 9-KidString.length(); i ++)
            {
                System.out.print(" ");
            }
            

            System.out.println("|");
        }
    }
}