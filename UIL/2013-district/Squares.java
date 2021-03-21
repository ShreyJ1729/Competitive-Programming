import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Squares
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./10.in");
        Scanner scanner = new Scanner(new File(input.getAbsolutePath()));
        while (scanner.hasNext())
        {
            int num = scanner.nextInt();
            printPattern(num);
            System.out.println();
        }
    }

    static void printPattern(int n)
    {
        String output = "";
        // number of rows and  
        // columns to be printed 
        int s = n;
    
        // Upper Half 
        for (int i = 0; 
                i < (s / 2) + 1; i++)  
        { 
            int m = n; 
    
            // Decreasing part 
            for (int j = 0; j < i; j++)  
            {
                output += m + " ";
                m--; 
            } 
    
            // Constant Part
            for (int k = 0;  
                    k < s - 2 * i; k++)  
            { 
                output += n - i + " "; 
            } 
    
            // Increasing part. 
            m = n - i + 1; 
            for (int l = 0; l < i; l++)  
            { 
                output += m + " "; 
                m++; 
            } 
    
            output += "\n";
        } 
    
        // Lower Half 
        for (int i = s / 2 - 1; 
                i >= 0; i--)  
        { 
    
            // Decreasing Part 
            int m = n; 
            for (int j = 0; j < i; j++) 
            { 
                output += m + " "; 
                m--; 
            } 
    
            // Constant Part. 
            for (int k = 0;  
                    k < s - 2 * i; k++) 
            { 
                output += n - i + " "; 
            } 
    
            // Decreasing Part 
            m = n - i + 1; 
            for (int l = 0; l < i; l++)  
            { 
                output += m + " "; 
                m++; 
            } 
            output += "\n";
        } 

        // replace certain values with spaces
        for (int i = n; i > 0; i -= 2)
        {
            output = output.replace(String.valueOf(i+1), " ");
        }

        // replace remaining numbers with *
        for (int i = 1; i < n+1; i ++)
        {
            output = output.replace(String.valueOf(i), "*");
        }

        // fix bug
        if (n%2==0)
        {
            String[] arr = output.split("\n", 0);
            for (int i = 0; i < arr.length; i ++)
            {
                if (i!=n/2+1)
                    System.out.print(arr[i]+"\n");
            }
        }
        else
        {
            System.out.println(output);
        }
    } 

}