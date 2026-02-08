#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> tree;
vector<int> dp;

int dfs(int node)
{
    int ct = 0;
    for (int child : tree[node])
    {
        ct += dfs(child) + 1;
    }
    return dp[node] = ct;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    tree.resize(n + 1);
    dp.assign(n + 1, 0);

    for (int i = 2; i <= n; i++)
    {
        int parent;
        cin >> parent;
        tree[parent].push_back(i);
    }

    dfs(1);

    for (int i = 1; i <= n; i++)
    {
        cout << dp[i] << " ";
    }
    cout << "\n";

    return 0;
}
