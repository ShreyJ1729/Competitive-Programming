import java.io.*;
import java.util.*;
import java.lang.Math;

class Paulina
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Scanner sc = new Scanner(new File("paulina.dat"));
        Scanner sc = new Scanner(new File("JudgeData/paulina.dat"));

        mainloop: while (sc.hasNextLine())
        {
            int num;
            try
            {
                num = sc.nextInt();
            } catch (NoSuchElementException exception)
            {
                break mainloop;
            }
            
            double[] pos = new double[2];

            for (int i_ = 0; i_< num; i_++)
            {
                double dist = sc.nextDouble();
                double angle = sc.nextDouble();
                angle = Math.toRadians(angle);

                double xmove = dist * Math.cos(angle);
                double ymove = dist * Math.sin(angle);

                pos[0] += xmove;
                pos[1] += ymove;
            }
            if (String.format("%.4f", pos[0]).equals("-0.0000")) pos[0]=0;
            if (String.format("%.4f", pos[1]).equals("-0.0000")) pos[1]=0;

            System.out.printf("(%.4f, %.4f)\n",pos[0], pos[1]);
        }
    }
}