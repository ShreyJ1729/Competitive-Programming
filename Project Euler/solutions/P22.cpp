#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int score(string name)
{
    int sum = 0;
    for (int c : name)
    {
        sum += c - 'A' + 1;
        // cout << c - 'A'+ 1 << " ";
    }

    return sum;
}


string get_min_name(vector<string> names)
{
    string min = names[0];

    for (string name : names)
    {
        if (name < min)
        {
            min = name;
        }
    }

    return min;
}


int main()
{
    ifstream fin("../data/P22_input.txt");

    string name;
    vector<string> names;
    vector<string> sorted_names;

    while (getline(fin, name, ','))
    {
        name.erase(remove(name.begin(), name.end(), '"'), name.end());
        names.push_back(name);
    }

    while (!names.empty())
    {
        string min_name = get_min_name(names);
        sorted_names.push_back(min_name);

        names.erase(remove(names.begin(), names.end(), min_name), names.end());
    }

    int sum = 0;
    for (int i = 0; i < sorted_names.size(); i++)
    {
        // we multiply by i+1 bc index 0 --> first. index 1 --> second, etc.
        sum += (i+1)*score(sorted_names[i]);
    }

    cout << sum;
}