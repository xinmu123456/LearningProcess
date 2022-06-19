#include "bits/stdc++.h"
using namespace std;

void pre_travel(const vector<vector<int>> &v, int t)
{
    cout << t << " ";
    if (v[t][1])
        pre_travel(v, v[t][1]);
    if (v[t][2])
        pre_travel(v, v[t][2]);
}

void in_travel(const vector<vector<int>> &v, int t)
{
    if (v[t][1])
        in_travel(v, v[t][1]);
    cout << t << " ";
    if (v[t][2])
        in_travel(v, v[t][2]);
}

void post_travel(const vector<vector<int>> &v, int t)
{
    if (v[t][1])
        post_travel(v, v[t][1]);
    if (v[t][2])
        post_travel(v, v[t][2]);
    cout << t << " ";
}

int main()
{
    int n, a, b, c;
    cin >> n;
    vector<vector<int>> v(n + 1, vector<int>(3, 0));
    cout << "n = " << n << endl;
    for (int i = 1; i < n + 1; i++)
    {
        cin >> a >> b >> c;
        v[i][0] = a;
        v[i][1] = b;
        v[i][2] = c;
    }
    printf("----------------\n");
    pre_travel(v, 2);
    printf("\n----------------\n");
    in_travel(v, 1);
    printf("\n----------------\n");
    post_travel(v, 1);
    printf("\n----------------\n");
}
