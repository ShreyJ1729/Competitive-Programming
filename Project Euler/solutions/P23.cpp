#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;
vector<int> abundants;

int sum_div(int n)
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

bool isAbundantSum(int n)
{
    for (int i : abundants)
    {
        if (i > n/2)
        {
            return false;
        }

        if (binary_search(abundants.begin(), abundants.end(), n-i))
        {
            return true;
        }
    }
    return false;
}

int main()
{
    for (int i = 2; i < 28123; i++)
    {
        if (sum_div(i) > i)
        {
            abundants.push_back(i);
        }
    }

    int sum = 0;
    for (int i = 0; i < 28123; i++)
    {
        if (!isAbundantSum(i))
        {
            sum += i;
        }
    }

    cout << sum;
}