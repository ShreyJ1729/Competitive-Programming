#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using std::cout;
using std::endl;

int len_cycle(int n)
{
    // std::vector<int> quotient;
    std::vector<int> rems;
    int d = 1;
    bool isRepeat = false;

    while (true)
    {
        // check to see if d == 0 (division terminated) or if rems has a repeat --> repeating decmimal
        if (d == 0)
        {
            break;
        }

        std::set<int> rems_sorted(rems.begin(), rems.end());
        if (!(rems.size() == rems_sorted.size()))
        {
            isRepeat = true;
            break;
        }

        d *= 10;
        rems.push_back(d);
        
        while (d < n)
        {
            d *= 10;
            // quotient.push_back(0);
            rems.push_back(d);
        }

        // quotient.push_back(d/n);
        d = d % n;
    }

    // for (int i : quotient)
    // {
    //     cout << i << " ";
    // }
    // cout << endl;
    // for (int i : rems)
    // {
    //     cout << i << " ";
    // }

    if (isRepeat)
    {
        int repeat = rems[rems.size()-1];
        for (int i = rems.size() - 2; i >= 0; i--)
        {
            if (rems[i] == repeat)
            {
                return (rems.size() - 1) - i;
            }
        }
    } else {
        return 0;
    }
}

int main()
{
    int d = 2;
    int max_len = 0;
    int clen;
    
    for (int i = 2; i < 1000; i++)
    {
        clen = len_cycle(i);
        if (clen > max_len)
        {
            max_len = clen;
            d = i;
        }
    }

    cout << d << endl;
    // cout << max_len << endl;
}