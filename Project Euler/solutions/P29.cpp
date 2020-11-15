#include <iostream>
#include <cmath>
#include <vector>
#include <set>

using namespace std;

vector<int> get_clean_pow(int n)
{
    int base = n;
    int power = 1;
    for (int i = 2; i <= 10; i++)
    {
        if (n % i == 0)
        {
            base = i;
            power = round(log(n)/log(base));
            // cout << base << ", " << power << " --> " << (int) round(pow(base, power)) << endl;
            if (round(pow(base, power)) == n)
            {
                // cout << "found ans. breaking.." << endl;
                break;
            } else {
                base = n;
                power = 1;
            }
        }
    }
    vector<int> ans = {base, power};
    return ans;
}

int main()
{
    vector<vector<int>> nums;

    // populating nums vector
    for (int a = 2; a <= 100; a ++)
    {
        for (int b = 2; b <= 100; b++)
        {
            vector<int> pair;
            pair.push_back(a);
            pair.push_back(b);
            nums.push_back(pair);
        }
    }

    set<vector<int>> uniques;
    vector<int> clean;
    int clean_pow;
    int clean_base;
    // go back and clean nums vector. ex <8, 2> --> <2, 6> and make cleaned set
    for (int i = 0; i < nums.size(); i++)
    {
        clean = get_clean_pow(nums[i][0]);
        // nested exponent rules --> multiply
        clean_pow = nums[i][1] * clean[1];
        clean_base = clean[0];

        vector<int> cleaned_item = {clean_base, clean_pow};
        uniques.insert(cleaned_item);
    }

    // for (vector<int> i : uniques)
    // {
    //     cout << i[0] << ", " << i[1] << endl;
    // }

    cout << uniques.size() << endl;
}