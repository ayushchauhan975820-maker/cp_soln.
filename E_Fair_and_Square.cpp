#include <bits/stdc++.h>
using namespace std;

#define ll long long

int n;
vector<bool> sq;
vector<vector<int>> tree;
vector<int> sz;
vector<int> par_of;

void dfs(int u, int p) {
    sz[u] = 1;
    par_of[u] = p;

    for (int v : tree[u]) {
        if (v != p) {
            dfs(v, u);
            sz[u] += sz[v];
        }
    }
}

bool is_sq(ll val){
    ll root = round(sqrt(val));
    return root * root == val;
}

void solve() {
    cin >> n;
    vector<ll> a(n + 1, 0);
    for(int i = 1; i <= n; i++) cin >> a[i];
    sq = vector<bool>(n + 1, false);
    for(int i = 1; i <= n; i++){
        sq[i] = is_sq(a[i]);
    }
    tree = vector<vector<int>>(n + 1);
    for(int i = 2; i <= n; i++){
        int a, b; cin >> a >> b;
        tree[b].push_back(a);
        tree[a].push_back(b);
    }
    sz.assign(n + 1, 0);
    par_of.assign(n + 1, 0);
    dfs(1, 0);
    ll ans = 0;
    for(int i = 1; i <= n; i++){
        if(!sq[i]) continue;

        vector<ll> brnch;
        for(int node : tree[i]){
            if(node != par_of[i]){
                brnch.push_back(sz[node]);
            }
        }
        if(i != 1){
            brnch.push_back(n - sz[i]);
        }

        ll c1 = 0;
        ll c2 = 0;
        ll c3 = 0;
        for(ll s: brnch){
            c3 += c2 * s;
            c2 += c1 * s;
            c1 += s;
        }
        ans += c3 + c2;
    }

    cout << ans << '\n';
}

/* 
    mid must be ps
*/

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