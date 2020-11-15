#include <iostream>
#include <fstream>
#include <string>

using namespace std;
int main()
{
    ifstream fin("../data/P11_input.txt");

    string data;
    int count = 0;
    int arr[20][20];

    while (fin >> data)
    {
        if (data[0] == '0')
        {
            data = data[1];
        }
        arr[count/20][count%20] = stoi(data);
        count ++;
    }

    int prod = 1;
    int max_prod = 0;

    // up-down products
    for (int i = 0; i < 17; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            prod = arr[i][j]*arr[i+1][j]*arr[i+2][j]*arr[i+3][j];
            if (prod > max_prod) max_prod = prod;
        }
    }

    // left-right products
    for (int i = 0; i < 20; i++)
    {
        for (int j = 0; j < 17; j++)
        {
            prod = arr[i][j]*arr[i][j+1]*arr[i][j+2]*arr[i][j+3];
            if (prod > max_prod) max_prod = prod;
        }
    }

    // diagonal top left --> bottom right products
    for (int i = 0; i < 20; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            if (i+3 < 20 && j+3 < 20)
            {
                prod = arr[i][j]*arr[i+1][j+1]*arr[i+2][j+2]*arr[i+3][j+3];
                if (prod > max_prod) max_prod = prod;
            }
        }
    }

    for (int i = 0; i < 20; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            if (i+3 < 20 && j-3 >= 0)
            {
                prod = arr[i][j]*arr[i+1][j-1]*arr[i+2][j-2]*arr[i+3][j-3];
                if (prod > max_prod) max_prod = prod;
            }
        }
    }


    cout << max_prod;
}