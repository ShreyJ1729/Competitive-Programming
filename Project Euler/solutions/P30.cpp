#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

int isFifthPow(int n)
{
    vector<int> digits;
    string n_str = to_string(n);
    for (int i = n_str.length() - 1; i >= 0; i --)
    {
        digits.push_back( (int) (n_str[i] - '0') );
    }
    // for (int i : digits) cout << i << " ";
    sort(digits.begin(), digits.end(),  greater<int>());
    // cout << endl;

    int sum = 0;
    for (int i : digits)
    {
        sum += pow(i, 5);
        if (sum > n) return false;
        // cout << i << " ";
    }
    // cout << "sum: " << sum << endl;
    if (sum == n)
    {
        return true;
    }
    return false;
}


int main()
{
    int sum = 0;
    // 9^5 * n = 10^n-1 graph has an intersection between n=5 and 6 so we do 6 0s to be safe.
    for (int i = 2; i < 1000000; i++)
    {
        if (isFifthPow(i))
        {
            cout << i << endl;
            sum += i;
        }
    }

    cout << sum;
}