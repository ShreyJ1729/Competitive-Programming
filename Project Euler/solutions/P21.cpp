#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int d(int n)
{
    vector<int> divisors = {1};
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            if (i*i == n)
            {
                divisors.push_back(i);
            } else {
                divisors.push_back(i);
                divisors.push_back(n/i);
            }
        }
    }


    int sum = 0;

    for (int i : divisors)
    {
        sum += i;
    }

    return sum;
}

int main()
{
    vector<int> amicables;

    // now double iterate and save amicable numbers to vector<int>
    int sum = 0;
    for (int i = 2; i < 10000; i++)
    {
        int di = d(i);
        if (di != i && d(di) == i)
        {
            sum += i;
            // cout << i << endl;
        }
    }
    cout << sum << endl;
}