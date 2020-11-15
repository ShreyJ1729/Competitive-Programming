#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

map<int, string> get_teen_map()
{
    map<int, string> teens;
    teens[10] = "ten";
    teens[11] = "eleven";
    teens[12] = "twelve";
    teens[13] = "thirteen";
    teens[14] = "fourteen";
    teens[15] = "fifteen";
    teens[16] = "sixteen";
    teens[17] = "seventeen";
    teens[18] = "eighteen";
    teens[19] = "nineteen";
    return teens;
}

int main()
{
    vector<string> ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    vector<string> tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    map<int, string> teens = get_teen_map();

    int count = 0;
    string num_string;


    for (int i = 1; i < 1000; i++)
    {
        if (i >= 10 && i <= 19)
        {
            num_string = teens[i];
        } else {
            int hundreds_i = i/100;
            int tens_i = (i/10) % 10;
            int ones_i = i % 10;

            if (hundreds_i == 0)
            {
                // if it's two digit ignore hundreds place
                num_string = tens[tens_i] + ones[ones_i];
            } else {
                if (tens_i == 0 && ones_i == 0)
                {
                    // if multiple of one hundred do this
                    num_string = ones[hundreds_i] + "hundred";
                } else if (tens_i == 1)
                {
                    // teens for hundres
                    num_string = ones[hundreds_i] + "hundredand" + teens[ones_i+10];
                } else {
                    // all others
                    num_string = ones[hundreds_i] + "hundredand" + tens[tens_i] + ones[ones_i];
                }
            }
        }
        // cout << num_string << endl;
        count += num_string.length();
    }

    // ADD CASE FOR 1000
    string thousand = "onethousand";
    count += thousand.length();

    cout << count << endl;
}