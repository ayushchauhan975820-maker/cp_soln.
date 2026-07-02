#include <bits/stdc++.h>
using namespace std;

#define ll long long

struct DSU{
    vector<int> parent;
    vector<int> size;
    DSU(int n): parent(n + 1), size(n + 1){
        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x){
        if(parent[x] == x) return x;
        int cur_par = parent[x];
        parent[x] = find(cur_par);
        return parent[x];
    }

    void combine(int a, int b){
        int par_a = find(a);
        int par_b = find(b);
        if(par_a == par_b) return;
        if(size[par_a] >= size[par_b]){
            parent[par_b] = par_a;
            size[par_a] += size[par_b];
        } else {
            parent[par_a] = par_b;
            size[par_b] += size[par_a];
        }
        return;
    }

    bool is_connected(int a, int b){
        int par_a = find(a);
        int par_b = find(b);
        return par_a == par_b;
    }
};

vector<vector<int>> graph;
vector<bool> vis;

bool dfs(int cur, int v, vector<int>& path){
    if(cur == v){
        path.push_back(v);
        return true;
    }
    vis[cur] = true;
    for(int neigh : graph[cur]){
        if(!vis[neigh]){
            bool in_path = dfs(neigh, v, path);
            if(in_path) {
                path.push_back(cur);
                return true;
            }
        }
    }
    return false;
}

void solve() {
    ll n, m;
    cin >> n >> m;
    graph = vector<vector<int>>(n + 1);
    vector<array<ll,3>> edges(m);
    for(int i = 0; i < m; i++){
        cin >> edges[i][0] >> edges[i][1] >> edges[i][2];
    }

    sort(edges.begin(), edges.end(), [](auto &a, auto &b) {
        return a[2] > b[2];
    });

    DSU dsu(n);

    int u = -1;
    int v = -1;
    int mn = 1e9;
    for(int i = 0; i < m; i++){
        int x = edges[i][0];
        int y = edges[i][1];
        int wt = edges[i][2];
        bool cycle = dsu.is_connected(x, y);
        dsu.combine(x, y);
        if(!cycle){
            graph[x].push_back(y);
            graph[y].push_back(x);
        } else if (wt < mn){
            mn = wt;
            u = x;
            v = y;
        }
    }

    if(u == -1) {
        cout << 0 << '\n';
        return;
    }

    vis = vector<bool>(n + 1, false);
    vector<int> path;

    dfs(u, v, path);

    cout << mn << " " << path.size() << '\n';
    for(int i = 0; i < path.size(); i++) cout << path[i] << " ";
    cout << '\n';
}

/* 
    if removing a edge doesn't disconnect two edge ends then that edge can be a cycle edge
    then its min of such edges
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