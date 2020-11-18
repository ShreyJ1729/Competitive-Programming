#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

int facts[] = {1, 1, 2, 3*2, 4*3*2, 5*4*3*2, 6*5*4*3*2, 7*6*5*4*3*2, 8*7*6*5*4*3*2, 9*8*7*6*5*4*3*2};

int factorial(int n)
{
    return facts[n];
}

vector<int> get_digits(int n)
{
    vector<int> digits;
    string n_str = to_string(n);
    for (int i : n_str)
    {
        digits.push_back( i - '0' );
    }
    return digits;
}

bool is_fact(int n)
{
    vector<int> digits = get_digits(n);

    sort(digits.begin(), digits.end(), greater<int>());
    for (int d : digits)
    {
        if (n < 0)
        {
            break;
        }
        n -= factorial(d);
    }
    // cout << n << ", " << n << endl;
    if (n == 0)
    {
        return true;
    }
    return false;
}

int main()
{
    vector<int> digits;
    bool status;
    int sum = 0;
    // The equation 9! * n = 10^n - 1 has an intersection somewhere between n=6 and n=7.
    // But 7 * 9! = 2540160 so this is a lazy upper bound. But 2499999 has a fact sum of 1814426 so the new upper bound is 1999999
    
    for (int i = 10; i < 1999999; i++)
    {
        status = true;
        digits = get_digits(i);
        if (is_fact(i))
        {
            // for (int d : digits)
            // {
            //     cout << d << " ";
            // }
            // cout << endl;
            sum += i;
        }
    }

    cout << sum;
}