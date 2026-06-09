#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve(){
    ll n, k; 
    cin >> n >> k;
    string s, t; cin >> s >> t;

    vector<vector<int>> list(26);
    for(int i = 0; i < n; i++){
        list[s[i] - 'a'].push_back(i);
    }

    vector<int> lst(n, 0);
    bool valid = true;
    int lst_pck = n - 1;
    int mx = 0;
    for(int i = n - 1; i >= 0; i--){
        int ch = t[i] - 'a';
        int l = 0;
        int r = list[ch].size() - 1;
        int max = min(i, lst_pck);
        int av = -1;
        while(l <= r){
            int mid = l + (r - l)/2;

            if(list[ch][mid] <= max) {
                av = list[ch][mid];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if(av == -1) valid = false;
        lst[i] = av;
        lst_pck = av;
        mx = std::max(mx, i - av);
    }

    if(!valid || mx > k) {
        cout << "-1" << '\n';
        return;
    }

    cout << mx << '\n';
    int step = 1;
    while(mx-- > 0){
        string sd = "";
        for(int i = 0; i < n; i++){
            sd += s[max(lst[i], i - step)];
        }
        step++;
        cout << sd << '\n';
    }
    return;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t; 
    while(t-- > 0){
        solve();
    }

    return 0;
}