#include <bits/stdc++.h>
using namespace std;

void search();

vector<int> permutation;

const int n = 3;
bool chosen[n + 1];

int main()
{
    search();
    return 0;
}

void search()
{
    if (permutation.size() == n)
    {
        for (int i = 0; i < n; i++)
            cout << permutation[i] << " ";
        cout << endl;
    }
    else
    {
        for (int i = 1; i <= n; i++)
        {
            if (chosen[i])
                continue;
            chosen[i] = true;
            permutation.push_back(i);
            search();
            chosen[i] = false;
            permutation.pop_back();
        }
    }
}
