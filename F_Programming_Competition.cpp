#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int n;
vector<vector<int>> ls;

vector<int> dfs(int node){
    // no of empty node, no of matches
    int matches = 0;
    priority_queue<int> av;
    for(int child: ls[node]){
        vector<int> cur = dfs(child);
        av.push(cur[0]);
        matches += cur[1];
    }
    while(av.size() > 1){
        int mx = av.top();
        av.pop();
        int smx = av.top();
        av.pop();

        matches += smx;
        if(mx - smx > 0){
            av.push(mx - smx);
        }
    }

    int rest = 1;
    if(av.size() == 1) rest += av.top();
    vector<int> vec = {rest, matches};
    return vec;
}

void solve(){
    cin >> n;
    ls.assign(n + 1, {});
    // for(int i = 0; i <= n; i++) ls[i] = vector<int>;
    for(int i = 2; i <= n; i++){
        int par; cin >> par;
        ls[par].push_back(i);
    }

    vector<int> ans = dfs(1);
    cout << ans[1] << '\n';
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t; cin >> t;
    while(t-- > 0){
        solve();
    }

    return 0;
}