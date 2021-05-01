import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mayank {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File ("mayank.dat"));
        HashMap<Character, Integer> val = new HashMap<>();
        val.put('A',1);
        val.put('B',2);
        val.put('C',3);
        val.put('D',4);
        val.put('E',5);
        val.put('F',6);
        val.put('G',7);
        val.put('H',8);
        val.put('J',1);
        val.put('K',2);
        val.put('L',3);
        val.put('M',4);
        val.put('N',5);
        val.put('P',7);
        val.put('R',9);
        val.put('S',2);
        val.put('T',3);
        val.put('U',4);
        val.put('V',5);
        val.put('W',6);
        val.put('X',7);
        val.put('Y',8);
        val.put('Z',9);
//        for (Map.Entry<Character, Integer> item : val.entrySet())
//        {
//            System.out.println(item.toString());
//        }
        int[] weights = new int[] {8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2};
        int n = sc.nextInt();

        for (int j = 1; j <= n; j++) {

            String data = sc.next();
            char[] s = data.toCharArray();
            char checkDig = s[8];
            //System.out.println(checkDig);
            int z;
            if (Character.isDigit(checkDig))
                z = checkDig - 48;
            else {
                z = val.get(checkDig);
            }
            int[] values = new int[s.length];
            int[] product = new int[s.length];
            int sum = 0;

            for (int i = 0; i < s.length; i++) {
                if (!Character.isDigit(s[i]))
                    values[i] = val.get(s[i]);
                else {
                    int x = Integer.parseInt(s[i] + "");
                    values[i] = x;
                }
                product[i] = values[i] * weights[i];
                sum += product[i];
            }

            if (sum % 11 == z) {
                System.out.println("#" + j + ": VALID");
            }
            else if (sum % 11 == 10 && s[8] == 'X')
            {
                System.out.println("#" + j + ": VALID");
            }
            else
                System.out.println("#" +j + ": INVALID " + (sum % 11));
        }
    }
}


