import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

class Seema
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("./District2020 JudgeDataFiles/seema.dat");
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter(",");

        TreeMap<String, Integer> states = new TreeMap<String, Integer>();
        String[] line = scanner.nextLine().split(",");

        for (String state : line)
        {
            if (!states.containsKey(state))
            {
                states.put(state, 1);
            }
            else
            {
                states.put(state, states.get(state)+1);
            }
        }

        System.out.println(states);
        
    }
}