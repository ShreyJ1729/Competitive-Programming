#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

const int triangle_size = 100;

void print_array(int (&arr) [triangle_size][triangle_size])
{
    for (int i = 0; i < triangle_size; i++)
    {
        for (int j = 0; j < triangle_size; j++)
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
    ifstream fin("input.txt");

    int num;
    int row = 0;
    int column = 0;
    int col_count = 1;
    int arr[triangle_size][triangle_size];

    // read in data to 2d array
    while (fin >> num)
    {
        // cout << "setting " << row << " " << column << " with col_count " << col_count << " to " << num << endl;
        arr[row][column] = num;
        
        column ++;
        if (column >= col_count)
        {
            fill(arr[row]+col_count, arr[row]+triangle_size, 0);
            column = 0;
            row ++;
            col_count ++;
        }
    }

    // print triangular array
    print_array(arr);

    // dynamically iterate over triangle
    // bottom --> up, adding max of next row's choices to each of previous row elements
    for (int row = triangle_size - 2; row >= 0; row --)
    {
        for (int col = 0; col <= row; col ++)
        {
            arr[row][col] += max(arr[row+1][col], arr[row+1][col+1]);
        }
    }

    cout << arr[0][0];
}