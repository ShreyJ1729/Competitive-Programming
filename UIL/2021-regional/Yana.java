import java.util.*;
import java.lang.Math;
import java.io.*;

class Yana
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("yana.dat");
        Scanner scan = new Scanner(file);

        char[][] arr = new char[][] {
                {'0', '8', 'G', 'O', 'W', 'd', 'l', 't'},
                {'1', '9', 'H', 'P', 'X', 'e', 'm', 'u'},
                {'2', 'A', 'I', 'Q', 'Y', 'f', 'n', 'v'},
                {'3', 'B', 'J', 'R', 'Z', 'g', 'o', 'w'},
                {'4', 'C', 'K', 'S', '-', 'h', 'p', 'x'},
                {'5', 'D', 'L', 'T', 'a', 'i', 'q', 'y'},
                {'6', 'E', 'M', 'U', 'b', 'j', 'r', 'z'},
                {'7', 'F', 'N', 'V', 'c', 'k', 's', '.'},
            };

        int num = scan.nextInt();

        for (int casenum=0; casenum<num; casenum++)
        {
            char[][] arr2 = new char[][] {
                {'0', '8', 'G', 'O', 'W', 'd', 'l', 't'},
                {'1', '9', 'H', 'P', 'X', 'e', 'm', 'u'},
                {'2', 'A', 'I', 'Q', 'Y', 'f', 'n', 'v'},
                {'3', 'B', 'J', 'R', 'Z', 'g', 'o', 'w'},
                {'4', 'C', 'K', 'S', '-', 'h', 'p', 'x'},
                {'5', 'D', 'L', 'T', 'a', 'i', 'q', 'y'},
                {'6', 'E', 'M', 'U', 'b', 'j', 'r', 'z'},
                {'7', 'F', 'N', 'V', 'c', 'k', 's', '.'},
            };


            String[] line = scan.next().split(",");
            scan.nextLine();
            int num2 = Integer.parseInt(line[line.length-1]);

            for (int i = 0; i < 8; i ++)
            {
                int shift = Integer.parseInt(line[i]);
                for (int j = 0; j < shift; j ++)
                {
                    char temp = arr2[7][i];
                    arr2[7][i] = arr2[6][i];
                    arr2[6][i] = arr2[5][i];
                    arr2[5][i] = arr2[4][i];
                    arr2[4][i] = arr2[3][i];
                    arr2[3][i] = arr2[2][i];
                    arr2[2][i] = arr2[1][i];
                    arr2[1][i] = arr2[0][i];
                    arr2[0][i] = temp;
                }
            }

            for (char[] arri : arr2)
            {
                // System.out.println(Arrays.toString(arri));
            }

            for (int testnum=0; testnum<num2; testnum++)
            {
                String words = scan.nextLine().replace(" ", "-");
                // System.out.println(words);
                String ans = "";

                for (int idx = 0; idx < words.length(); idx++)
                {
                    char c = words.charAt(idx);
                    for (int i = 0; i < arr.length; i ++)
                    {
                        for (int j = 0; j < arr[0].length; j ++)
                        {
                            if (arr[i][j]==c)
                            {
                                ans+=arr2[i][j];
                                break;
                            }
                        }
                    }
                }
                System.out.printf("[%d:%d]--\"", casenum+1, 1+testnum);
                System.out.println(ans+"\"");
            }
            System.out.println("==========");
        }
    }
}