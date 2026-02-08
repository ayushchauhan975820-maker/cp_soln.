#include <bits/stdc++.h>

using namespace std;
using ll = long long;

void solve()
{
    ll x, n, m;
    cin >> x >> n >> m;
    n = min(n, 32LL);
    m = min(m, 32LL);
    ll min = x;
    ll max = x;

    for (int i = 0; i < n; i++)
    {
        max = max / 2;
    }
    for (int i = 0; i < m; i++)
    {
        max = (++max) / 2;
    }

    for (int i = 0; i < m; i++)
    {
        min = (++min) / 2;
    }
    for (int i = 0; i < n; i++)
    {
        min = min / 2;
    }

    cout << min << " " << max << "\n";
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