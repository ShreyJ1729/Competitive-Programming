#include <iostream>
#include <cmath>

using namespace std;

int tri(int n)
{
    return n*(n+1)/2;
}

int num_divisors(int n)
{
    // start with 1 because n itself is a divisor but we only go 1 --> floor(n/2)
    int count = 1;
    for (int i = 1; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            // since we're only going to sqrt(n), every found divisor has a pair so we add 2 if it's not the square root
            if (i*i == n)
            {
                count ++;
            } else {
                count += 2;
            }
            // cout << "divisor: " << i << endl;
        }
    }
    // cout << "divisor: " << n << endl;
    return count;
}

int main()
{
    int n = 1;
    while (num_divisors(tri(n)) <= 500)
    {
        // cout << "num: " << tri(n) << endl;
        // cout << num_divisors(tri(n)) << endl;
        n++;
    }

    cout << tri(n);

}