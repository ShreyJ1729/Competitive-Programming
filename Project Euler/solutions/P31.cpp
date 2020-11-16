#include <iostream>

int digits[] = {1, 2, 5, 10, 20, 50, 100, 200};

// nice recursion

int count(int n, int m)
{
    if (n < 0 || m < 0) return 0;
    if (n==0||n==1) return 1;
    return count(n, m-1) + count(n - digits[m], m);
}

int main()
{
    std::cout << count(200, 7);
}