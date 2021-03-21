import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
class Dawn
{
    public static void main(String[] args) throws FileNotFoundException
    {

                System.out.println("     Amount                             Monthly         Total of");
        
System.out.println("....Invested........APR......Years......Payment.........Payments............Profit..");
        File input = new File("./District Judge dat files/dawn.dat");
        Scanner scanner = new Scanner(new File(input.getAbsolutePath()));
        int num = scanner.nextInt();

        double a_total = 0;
        double monthly_total = 0;
        double total_total = 0;
        double profit_total = 0;

        for (int i = 1; i < num+1; i ++)
        {
            double a = scanner.nextDouble();
            double yearly_apr_print = scanner.nextDouble();
            double yearly_apr = yearly_apr_print/100;
            double r = yearly_apr/12;
            int years = scanner.nextInt();

            a_total+=a;

            double payment = Math.round( a*r / (1 - Math.pow(1+r, -years*12)) * 100)/100.0;
            double total_payment = Math.round(payment*12*years * 100.0)/100.0;
            monthly_total+=payment;
            total_total+=payment*12;
            double profit = payment*12*years - a;
            profit_total+=profit;

            String ans = format(0, String.format("%,.2f", a), 14) + "|" + format(String.format("%,.3f", yearly_apr_print)+"%", 11)
                    +"|" + format(years+"",8)
                    +"|"+format(2, String.format("%,.2f", payment), 14)
                    +"|"+format(2, String.format("%,.2f", total_payment), 17) +"|"+format(2, String.format("%,.2f", profit), 15);
            System.out.println(ans);
        }


        String ans = format(0, String.format("%,.2f", a_total), 14) + "|                    |"+
                format(2, String.format("%,.2f", monthly_total), 14)
                +"|"+format(2, String.format("%,.2f", total_total), 17) +"|"+format(2, String.format("%,.2f", profit_total), 15);
        System.out.println(ans);

    }

    public static String format(int left, String st, int width){
        String res = "";
        for(int i =0; i < left; i++) res += " ";
        res +="$";
        for(int i = 0; i < width - 2 - left - st.length(); i++) res += " ";
        res += st;
        res += "  ";
        return res;
    }

public static String format(String st, int width){
        String res = "";
        for(int i = 0; i < width - 2 - st.length(); i++) res += " ";
        res += st;
        res += "  ";
        return res;
    }
}