import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Richa {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("richa.dat"));
        int n = sc.nextInt(); sc.nextLine();
        ArrayList<Course> course = new ArrayList<>();
        while (n --> 0)
        {
            String line[] = sc.nextLine().split(" ");
            int num = Integer.parseInt(line[0]);
            String hon = line[1].charAt(0) + "";
            int creds = 0;
            boolean honors = false;
            if (hon.equals("Y"))
                honors = true;
            else
                honors = false;
            char type = line[1].charAt(1);
            if (type == 'Q')
                creds = 1;
            if (type == 'S')
                creds = 2;
            if (type == 'Y')
                creds = 4;
            course.add(new Course(num,honors,creds));
        }
        while (sc.hasNextLine())
        {
            String grades[] = sc.nextLine().split(" ");
            //System.out.println(Arrays.toString(grades));
            double gpa = 0;
            double grade1 = 0;
            double grade2 = 0;
            int creds1 = 0;
            int creds2 = 0;
            boolean honors1 = false;
            boolean honors2 = false;

            for (int i = 0; i < course.size(); i++)
            {
                if (Integer.parseInt(grades[1]) == course.get(i).courseNumber) {
                    creds1 = course.get(i).credits;
                    honors1 = course.get(i).honors;
                }
                if (Integer.parseInt(grades[3]) == course.get(i).courseNumber) {

                    creds2 = course.get(i).credits;
                    honors2 = course.get(i).honors;
                }
            }
            String gradeA = grades[0];
            String gradeB = grades[2];
            if (gradeA.equals("A+"))
                grade1 = 4.75;
            if (gradeA.equals("A"))
                grade1 = 4.5;
            if (gradeA.equals("A-"))
                grade1 = 4.25;
            if (gradeA.equals("B+"))
                grade1 = 3.75;
            if (gradeA.equals("B"))
                grade1 = 3.5;
            if (gradeA.equals("B-"))
                grade1 = 3.25;
            if (gradeA.equals("C+"))
                grade1 = 2.75;
            if (gradeA.equals("C"))
                grade1 = 2.5;
            if (gradeA.equals("C-"))
                grade1 = 2.25;
            if (gradeA.equals("D+"))
                grade1 = 1.25;
            if (gradeA.equals("D"))
                grade1 = 1;
            if (gradeA.equals("D-"))
                grade1 = 0.75;
            if (gradeA.equals("F"))
                grade1 = 0;
            //
            if (gradeB.equals( "A+"))
                grade2 = 4.75;
            if (gradeB.equals("A"))
                grade2 = 4.5;
            if (gradeB.equals("A-"))
                grade2 = 4.25;
            if (gradeB.equals( "B+"))
                grade2 = 3.75;
            if (gradeB .equals( "B"))
                grade2 = 3.5;
            if (gradeB .equals("B-"))
                grade2 = 3.25;
            if (gradeB .equals( "C+"))
                grade2 = 2.75;
            if (gradeB .equals( "C"))
                grade2 = 2.5;
            if (gradeB .equals("C-"))
                grade2 = 2.25;
            if (gradeB .equals("D+"))
                grade2 = 1.25;
            if (gradeB .equals("D"))
                grade2 = 1;
            if (gradeB .equals("D-"))
                grade2 = 0.75;
            if (gradeB .equals( "F"))
                grade2 = 0;
            //System.out.println(honors1);
            if (honors1)
                grade1 += 0.5;
            if (honors2)
                grade2 += 0.5;
            System.out.println(honors2);
            System.out.println(grade1 + " " + creds1 + " " + grade2 + " " + creds2);
            System.out.println((grade1 * creds1 + grade2 * creds2));
            gpa = (grade1 * creds1 + grade2 * creds2) /  (creds1 + creds2);
            System.out.printf("%5.3f\n",gpa);
        }
    }

    static class Course
    {
        public int courseNumber;
        public boolean honors;
        public int credits;
        public Course(int x, boolean c, int k)
        {
            courseNumber = x;
            honors = c;
            credits = k;
        }
    }
}



