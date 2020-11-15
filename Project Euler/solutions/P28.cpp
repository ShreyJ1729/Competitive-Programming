#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void gen_spiral(vector<vector<int>> &spiral, int size)
{
    int num = 1;
    int square_size = 1;
    int x = size/2;
    int y = size/2;
    spiral[y][x] = 1;

    while (true)
    {
        if (square_size == size) break;

        x ++;
        num ++;
        square_size += 2;
        spiral[y][x] = num;

        // going down from exit point
        for (int i = 0; i < square_size - 2; i ++)
        {
            y ++;
            num ++;
            spiral[y][x] = num;
        }

        // going left
        for (int i = 0; i < square_size - 1; i ++)
        {
            x --;
            num ++;
            spiral[y][x] = num;
        }

        // going up
        for (int i = 0; i < square_size - 1; i ++)
        {
            y --;
            num ++;
            spiral[y][x] = num;
        }

        // going right
        for (int i = 0; i < square_size - 1; i ++)
        {
            x ++;
            num ++;
            spiral[y][x] = num;
        }
    }
}

void print_spiral(int size, vector<vector<int>> &spiral)
{
    int max_log = (int) log10(size*size);
    int curr_log;

    for (vector<int> i : spiral)
    {
        for (int j : i)
        {
            // this is to get the 0s nicely formatted and stuff
            curr_log = max_log - ((int) log10(j));
            for (int i = 0; i < curr_log; i++)
            {
                cout << "0";
            }

            cout << j << " ";
        }
        cout << endl;
    }
}

int main()
{
    int size = 1001;
    vector<vector<int>> spiral(size, vector<int> (size));
    gen_spiral(spiral, size);

    // print_spiral(size, spiral);

    // get diagonal sum
    int x = 0;
    int y = 0;
    int sum = 0;

    // top left to bottom right
    for (int i = 0; i < size; i++)
    {
        sum += spiral[y][x];
        x++;
        y++;
    }

    // top right to bottom left
    x = size - 1;
    y = 0;
    for (int i = 0; i < size; i++)
    {
        sum += spiral[y][x];
        x--;
        y++;
    }

    // remove double counted center
    sum -= 1;
    
    cout << sum << endl;
    
}