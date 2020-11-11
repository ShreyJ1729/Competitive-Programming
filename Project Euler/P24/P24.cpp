#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int get_break_idx(const vector<int> &perm)
{
    int break_idx = -1;
    for (int i = perm.size() - 1; i > 0; i--)
    {
        if (perm[i-1] < perm[i])
        {
            break_idx = i-1;
            break;
        }
    }
    return break_idx;
}

int get_rceil_idx(const vector<int> &perm, int break_idx)
{
    int rceil_idx = break_idx + 1;
    for (int i = break_idx; i < perm.size(); i++)
    {
        if (perm[i] > perm[break_idx] && perm[i] < perm[rceil_idx])
        {
            rceil_idx = i;
        }
    }
    return rceil_idx;
}

void swap(int* a, int* b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

vector<int> next_perm(vector<int> perm, const int break_idx)
{
    int rceil_idx = get_rceil_idx(perm, break_idx);

    swap(&perm[break_idx], &perm[rceil_idx]);
    sort(perm.begin() + break_idx + 1, perm.end());

    // cout << rceil_idx << endl;
    return perm;
}

int main()
{
    vector<int> seq = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int break_idx;
    int count = 1;

    while (true)
    {
        if (count == 1000000)
        {
            break;
        }
        break_idx = get_break_idx(seq);
        // cout << "bidx: " << break_idx << endl;
        seq = next_perm(seq, break_idx);
        
        if (break_idx == -1)
        {
            break;
        }

        // for (int i : seq)
        // {
        //     cout << i << " ";
        // }
        // cout << endl;
        
        count ++;
    }

    for (int i : seq)
    {
        cout << i;
    }

    cout << endl;
}