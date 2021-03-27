import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Gregory {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("Region Solutions_dat_out_files/gregory.dat"));
		String commonLetters[] = sc.nextLine().split("");
		String specialChars[] = sc.nextLine().split("");
		String commonPass[] = new String[100];
		char lowerCaseLetters[] = new char[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
		char upperCaseLetters[] = new char[] {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
		char nums[] = new char[] {'0', '1', '2', '3', '4', '5', '6','7','8','9'};
		int k = 0;
        for (int i = 0; i < 10; i++)
		{
			String temp[] = sc.nextLine().split(",");
			for (int j = 0; j < temp.length; j++)
			{
				commonPass[k] = temp[j]; k++;
			}
		}
		while (sc.hasNextLine())
		{
			String pass = sc.nextLine();
			int score = 0;
			//track what types of characters have been found.
			boolean lowerCase = false;
			boolean upperCase = false;
			boolean symbols = false;
			boolean digits = false;;
			
			//going character by character and scoring it
			for (int i = 0; i < pass.length(); i++)
			{
				char z = pass.charAt(i);
				String x = pass.charAt(i) + "";
				for (int j = 0; j < commonLetters.length; j++) 
				{
					if (x.equalsIgnoreCase(commonLetters[j]))
					{
						if (j <= (commonLetters.length-1)/2)
							score++;
						else
							score+=2;
					}
				}
				for (int j = 0; j < nums.length; j++) if (z == nums[j]) score +=2;
				for (int j = 0; j < specialChars.length; j++) if (x.equals(specialChars[j])) score+=3;
			}
			
			
			//checking for switches and triple charactesr
			for (int i = 0; i < pass.length(); i++)
			{
				boolean temp = false;
				char prevChar = 0;
				String prevX = "";
				String prevType = "";
				String currentType = "";
				if (i != 0)
				{
					prevChar = pass.charAt(i-1);
					prevX = prevChar + "";
					temp = true;
				}
				char x = pass.charAt(i);
				String xz = x + "";
				for (int j = 0; j < lowerCaseLetters.length; j++) 
				{
					if (x == lowerCaseLetters[j]) 
					{
						lowerCase = true;
						currentType = "lowerCase";
					}
					if (temp && prevChar == lowerCaseLetters[j])
					{
						prevType = "lowerCase";
					}
				}
				for (int j = 0; j < upperCaseLetters.length; j++) 
				{
					if (x == upperCaseLetters[j]) 
					{
						upperCase = true;
						currentType = "upperCase";
					}
					if (temp && prevChar == upperCaseLetters[j])
					{
						prevType = "upperCase";
					}
				}
				for (int j = 0; j < specialChars.length; j++)
				{
					if (xz.equals(specialChars[j])) 
					{
						symbols = true;
						currentType = "symbols";
					}
					if (temp && prevX.equals(specialChars[j]))
					{
						prevType = "symbols";
					}
				}
				for (int j = 0; j < nums.length; j++) 
				{
					if (x == nums[j]) 
					{
						digits = true;
						currentType = "digits";
					}
					if (temp && prevChar == nums[j])
					{
						prevType = "digits";
					}
				}
				//checing for repetition with prev char
				if (temp) 
					{if (x == prevChar) 
					{score--;}}
				if (temp && prevType != currentType)
				{
					score +=2;
					//System.out.println(score + prevType + " " + currentType);
				}
				//checking for triples
				if (i >= 2)
				{
					//x and prevChar
					char oldoldChar = pass.charAt(i-2);
					if (x - prevChar == 1)
					{
						if (prevChar - oldoldChar == 1)
						{
							score-=5;
						}
					}
				}
			}
			int tempScore = 0;
			if (lowerCase) tempScore++; if (upperCase) tempScore++; if (digits) tempScore++; if(symbols) tempScore++;
			if (tempScore < 3) score = 0;
			if (tempScore ==4) score+=5;
			if (pass.length() < 8)
				score = 0;
			else
			{
				int leftOver = pass.length() - 8;
				if (leftOver != 0)
				{
					score += 2 * leftOver;
				}
			}
			for (int i = 0; i < commonPass.length; i++)
			{
				if (pass.equalsIgnoreCase(commonPass[i])) score = 0;
			}
			//need to do sequence of 3 letters
			String output = pass + ":" + score + ":";
			if (score >= 41)
			{
				output += "STRONG";
			}
			else if (score >= 31) 
			{
				output += "GOOD";
			}
			else if (score >= 16)
			{
				output += "FAIR";
			}
			else if (score >= 1) 
			{
				output += "WEAK";
			}
			else
			{
				output += "UNACCEPTABLE";
			}
			System.out.println(output);
			//System.out.println(Arrays.toString(commonPass));
		}
		
	}

}