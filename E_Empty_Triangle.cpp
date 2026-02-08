#include <bits/stdc++.h>

using namespace std;
using ll = long long;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

void dfs(int x, int y, int z)
{
    cout << "? " << x << " " << y << " " << z << '\n';
    cout.flush();

    int idx;
    cin >> idx;
    if (idx == -1)
        exit(0);

    if (idx == 0)
    {
        cout << "! " << x << " " << y << " " << z << '\n';
        cout.flush();
        return;
    }

    int rnd = rng() % 3;
    if (rnd == 0)
    {
        dfs(idx, y, z);
    }
    else if (rnd == 1)
    {
        dfs(x, idx, z);
    }
    else
    {
        dfs(x, y, idx);
    }
    return;
}

void solve()
{
    int n;
    cin >> n;

    int x = 1;
    int y = (n + 1) / 2;
    int z = n;

    dfs(x, y, z);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
    {
        solve();
    }
    return 0;
}