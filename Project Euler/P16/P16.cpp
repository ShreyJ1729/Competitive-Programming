#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main()
{
    vector<int> num;
    num.push_back(1);
    int carry = 0;
    int power = 1000;

    // iterate as many times as power
    for (int curr_pow = 0; curr_pow < power; curr_pow++)
    {
        // first double everyhting in the vector
        for (int i = 0; i < num.size(); i++)
        {
            num[i] = 2 * num[i];
        }

        // then go back through and do the carries
        for (int i = num.size() - 1; i > 0; i--)
        {
            if (num[i] >= 10)
            {
                num[i] -= 10;
                num[i-1] ++;
            }
        }

        // for first number add a digit if >= 10
        if (num[0] >= 10)
        {
            num[0] -= 10;
            num.insert(num.begin(), 1);
        }
    }

    // cout << endl << "ans: ";
    int sum = 0;
    for (int i = 0; i < num.size(); i++)
    {
        // cout << num[i];
        sum += num[i];
    }

    cout << endl << sum;
}