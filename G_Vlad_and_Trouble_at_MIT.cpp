#include <bits/stdc++.h>
using namespace std;

#define ll long long

vector<vector<int>> tree;
string s;
int ans;

vector<int> dfs(int node, int par){
    int tot_s = 0;
    int tot_p = 0;
    char ch = s[node - 1];
    for(int child : tree[node]){
        if(child == par) continue;

        vector<int> sub = dfs(child, node);
        if(ch == 'P'){
            ans += sub[0];
        } else if(ch == 'S'){
            ans += sub[1];
        } else {
            tot_s += sub[0];
            tot_p += sub[1];
        }
    }

    if(ch == 'P') tot_p = 1;
    if(ch == 'S') tot_s = 1;
    if(ch == 'C' && tot_s > 0 && tot_p > 0) {
        ans += tot_p;
        tot_p = 0;
    }
    return {tot_s, tot_p};
}

void solve() {
    int n; cin >> n;
    tree = vector<vector<int>>(n + 1);
    for(int i = 2; i <= n; i++){
        int a; cin >> a;
        tree[i].push_back(a);
        tree[a].push_back(i);
    }
    cin >> s;
    ans = 0;

    int p = -1;
    for(int i = 0; i < n; i++){
        if(s[i] == 'P') p = i + 1;
    }

    if(p == -1){
        cout << 0 << '\n';
        return;
    }

    dfs(p, 0);
    cout << ans << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t = 1;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}