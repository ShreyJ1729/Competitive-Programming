#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool isPal(string n)
{
    string n2 = n;
    reverse(n.begin(), n.end());
    if (n[0] == '0') return false;
    if (n==n2) return true;
    return false;
}

string toBinary(int n)
{
    int power = 0;
    string bin = "";

    while (n > 0)
    {
        bin = (n%2==0 ? "0":"1")+bin;
        n/=2;
    }

    return bin;
}

bool isPalBoth(int n)
{
    if (isPal(to_string(n)) && isPal(toBinary(n))) return true;
    return false;
}

int main()
{
    int sum = 0;
    for (int i = 0; i<1000000; i++)
    {
        if (isPalBoth(i))
        {
            sum += i;
            // cout << i << endl;
        }
    }
    cout << sum;
}