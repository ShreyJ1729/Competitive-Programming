#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(int n)
{
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n%i==0)
        {
            return false;
        }
    }
    return true;
}

int quad(int a, int b, int n)
{
    return n*n+a*n+b;
}

int max_consec_primes(int a, int b)
{
    int curr = 0;
    while (true)
    {
        int curr_quad = quad(a, b, curr);
        if ( curr_quad <= 0 || !isPrime(curr_quad) )
        {
            break;
        }

        curr ++;
    }
    return curr;
}

int main()
{
    // for quad(a, b, n) to be prime, b must be prime and a+b must be prime

    int max_num_primes = 0;
    int best_prod = 0;

    for (int a = -1000; a < 1000; a ++)
    {
        for (int b = -1000; b <= 1000; b ++)
        {
            int curr_num_primes = max_consec_primes(a, b);
            if (curr_num_primes > max_num_primes)
            {
                max_num_primes = curr_num_primes;
                best_prod = a*b;
                // cout << "New best found: " << max_num_primes << " with a, b = " << a << ", " << b << endl;
            }
        }
    }
    cout << best_prod << endl;
    // cout << max_num_primes << endl;
}