#include <bits/stdc++.h>
using namespace std;

const int MONEY = 251;
const int VALUE = 5;

int type[VALUE] = {1, 5, 10, 25, 50};
int Min[MONEY];

void solve()
{
    for (int k = 0; k < MONEY; k++)
        Min[k] = INT_MAX;

    Min[0] = 0;
    for (int j = 0; j < VALUE; j++)
        for (int i = type[j]; i < MONEY; i++)
            Min[i] = min(Min[i], Min[i - type[j]] + 1);
}

int main()
{
    int s;
    solve();
    while (cin >> s)
        cout << Min[s] << endl;
    return 0;
}
