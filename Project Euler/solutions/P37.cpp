#include <iostream>
#include <cmath>
#include <string>

using namespace std;

bool isPrime(int n)
{
    if (n==1 || n==0) return false;
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n%i==0) return false;
    }
    return true;
}

bool isTrunc(int n)
{
    // from left side
    int n2 = n;
    while (true)
    {
        // cout << n << " ";
        if (!isPrime(n)) return false;
        n = n % (int) round(pow(10, to_string(n).length()-1));
        if (n == 0) break;
    }
    // cout << endl;

    // from right side
    while (true)
    {
        // cout << n2 << " ";
        if (!isPrime(n2)) return false;
        n2 = n2 / 10;
        if (n2==0) break;
    }
    // cout << endl;
    return true;
}

int main()
{
    int sum = 0;
    int count = 0;
    int curr = 11;

    while (count != 11)
    {
        // cout << "curr: " << curr << endl;
        if (isTrunc(curr))
        {
            count ++;
            sum += curr;
            // cout << "found trunc at " << curr << endl;
        }
        curr ++;
    }

    cout << sum;
}