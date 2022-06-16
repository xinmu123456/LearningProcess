#include <bits/stdc++.h>
using namespace std;

string s;
priority_queue<int, vector<int>, greater<int>> Q;

int main()
{
    while (getline(cin, s) && s != "END")
    {
        int t = 1;
        sort(s.begin(), s.end());
        for (unsigned int i = 1; i < s.length(); i++)
        {
            if (s[i] != s[i - 1])
            {
                Q.push(t);
                t = 1;
            }
            else
                t++;
        }
        Q.push(t);
    }
    int ans = 0;
    while (Q.size() > 1)
    {
        int a = Q.top();
        Q.pop();
        int b = Q.top();
        Q.pop();
        Q.push(a + b);
        ans += a + b;
    }
    cout << ans << endl;
    Q.pop();
    return 0;
}
