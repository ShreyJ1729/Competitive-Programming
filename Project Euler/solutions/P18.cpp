#include <iostream>
#include <fstream>
#include <vector>

/*

NOT FINISHED
So far only read in triangle array to 2d array.

*/

using namespace std;


void print_array(int (&arr) [15][15])
{
    for (int i = 0; i < 15; i++)
    {
        for (int j = 0; j < 15; j++)
        {
            if (arr[i][j] < 10)
            {
                cout << " ";
            }
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}

int main()
{
    ifstream fin("../data/P18_input.txt");

    int num;
    int row = 0;
    int column = 0;
    int col_count = 1;
    int arr[15][15];

    // read in data to 2d array
    while (fin >> num)
    {
        // cout << "setting " << row << " " << column << " with col_count " << col_count << " to " << num << endl;
        arr[row][column] = num;
        
        column ++;
        if (column >= col_count)
        {
            fill(arr[row]+col_count, arr[row]+15, 0);
            column = 0;
            row ++;
            col_count ++;
        }
    }

    // print triangular array
    print_array(arr);

    // dynamically iterate over triangle
    // bottom --> up, adding max of next row's choices to each of previous row elements
    for (int row = 13; row >= 0; row --)
    {
        for (int col = 0; col <= row; col ++)
        {
            arr[row][col] += max(arr[row+1][col], arr[row+1][col+1]);
        }
    }

    cout << arr[0][0];
}