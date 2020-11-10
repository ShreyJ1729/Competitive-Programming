#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
    ifstream fin("input.txt");
    unsigned long long int total = 0;

    string line;
    int count = 0;
    while (getline(fin, line))
    {

        unsigned long long int num = stoll(line.substr(0, 12), nullptr, 10);
        // cout << num << endl;
        count ++;
        total += num;
    }
    // cout << total << endl;
    cout << to_string(total).substr(0,10) << endl;
}