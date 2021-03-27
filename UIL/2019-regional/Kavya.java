import java.util.*;
import java.io.*;

public class Kavya {

	public static void main(String[] args) throws FileNotFoundException{
		TreeMap<String, Integer> map = new TreeMap<>();
		HashMap<String, Integer> map1 = new HashMap<>();
		Scanner sc = new Scanner(new File("Region Solutions_dat_out_files/kavya.dat"));
		while (sc.hasNextLine())
		{
			ArrayList<Pair> k = new ArrayList<>();

			String temp = sc.nextLine();
			for (int i = 0; i < temp.length(); i++)
			{
				String s = (temp.charAt(i) + "").toUpperCase();
				if (s.equals(" ") || s.equals(",") ||s.equals("!") ||s.equals("?") ||s.equals("."))
				{
					continue;
				}

				//check for numbers later
				boolean temp1 = false;
				for (int j = 0; j < k.size(); j++)
				{
					if (k.get(j).getA().equalsIgnoreCase(s))
					{
						k.get(j).setFrequency(k.get(j).getFrequency() + 1);
						temp1 = true;
						break;
					}
				}
				if (!temp1)
				{
					k.add(new Pair (s,i,1));
				}
				//map.put(s, map.getOrDefault(s, 0) + 1);
				//map1.put(s, map1.getOrDefault(s, 0) + 1);
			}
			compareAll compare = new compareAll();
			Collections.sort(k, compare);
			for (int i = 0; i < k.size(); i++)
			{
				for (int j = 0; j < k.get(i).getFrequency(); j++)
				{
					System.out.print(k.get(i).getA());
				}
			}
			System.out.println();
		}
	}
	
	static class Pair
	{
		private String a;
		private int index;
		private int frequency;
		public Pair(String a, int index, int frequency) {this.a = a; this.index = index; this.frequency = 1;}
		public String getA() {return this.a;}
		public int getIndex() {return this.index;}
		public int getFrequency() {
			return frequency;
		}
		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}
		public void setA(String a) {
			this.a = a;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		
	}
	
	static class compareAll implements Comparator<Pair>
	{
		public int compare(Pair p1, Pair p2)
		{
			if (p1.frequency > p2.frequency)
				return -1;
			else if (p1.frequency < p2.frequency)
				return 1;
			else if (p1.index < p2.index)
				return -1;
			else if (p1.index > p2.index)
				return 1;
			return 0;
					
		}
	}

}