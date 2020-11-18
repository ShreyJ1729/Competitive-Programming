#include <iostream>
#include <cmath>
#include <string>

using namespace std;

bool isPrime(int n)
{
    if (n==1) return false;
    if (n==2) return true;
    for (int i = 2; i <= sqrt(n); i ++)
    {
        if (n%i==0) return false;
    }

    return true;
}


bool isCirclePrime(int n)
{
    string n_str = to_string(n);
    for (int i = 0; i < n_str.length(); i ++)
    {
        if (!isPrime(n)) return false;

        n_str =n_str.substr(1) + n_str[0];
        n = stoi(n_str);
    }
    return true;
}

int main()
{
    int count = 0;
    for (int i = 2; i < pow(10, 6); i ++)
    {
        if (isCirclePrime(i)) count ++;
    }
    cout << count;
}