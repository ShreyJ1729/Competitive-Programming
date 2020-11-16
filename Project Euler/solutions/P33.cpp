#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main()
{
    vector<int> final_nums;
    vector<int> final_denums;

    for (int num = 10; num <= 99; num++)
    {
        for (int denum = 10; denum <= 99; denum ++)
        {
            if (num == denum) continue;
            
            double num_tens = num/10;
            double num_ones = num % 10;
            double denum_tens = denum/10;
            double denum_ones = denum % 10;
            double val = ((double)num)/denum;
            bool status = false;

            if (num_ones == 0 || denum_ones == 0) continue;

            if (num_ones == denum_ones)
            {
                if (abs(num_tens/denum_tens - val) <= 0.001)
                {
                    status = true;
                }
            }

            if (num_ones == denum_tens)
            {
                if (abs(num_tens/denum_ones - val) <= 0.001)
                {
                    status = true;
                }
            }

            if (num_tens == denum_ones)
            {
                if (abs(num_ones/denum_tens - val) <= 0.001)
                {
                    status = true;
                }
            }

            if (num_tens == denum_tens)
            {
                if (abs(num_ones/denum_ones - val) <= 0.001)
                {
                    status = true;
                }
            }

            if (num/denum >= 1)
            {
                status = false;
            }

            if (status)
            {
                // cout << num_tens << num_ones << " / " << denum_tens << denum_ones << endl;
                final_nums.push_back(num);
                final_denums.push_back(denum);
            }
        }
    }

    int num_prod = 1;
    int denum_prod = 1;
    for (int i : final_nums)
    {
        num_prod *= i;
    }

    for (int i : final_denums)
    {
        denum_prod *= i;
    }

    cout << (double)denum_prod/num_prod << endl;
}