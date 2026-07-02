
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll dfs(vector<ll>& a, vector<ll>& size, ll k){
    int n = size.size();
    for(int i = 0; i <= 200; i++){
        int l = 0;
        int r = n - 1;
        int idx = 0;
        // find the max index where size <= k
        while(l <= r){
            int mid = l + (r - l)/2;

            if(size[mid] <= k){
                idx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(size[idx] == k){
            return a[idx];
        } else {
            k %= size[idx];
            if(k == 0){
                k = size[idx];
            }
        }
    }
    return -1;
}

void solve(){
    int n, q; 
    cin >> n >> q;
    ll mx = 2e18;
    ll sz = 0;
    vector<ll> a;
    vector<ll> size;
    for(int i = 0; i < n; i++){
        int tp; cin >> tp;
        ll x; cin >> x;
        if(tp == 1){
            sz = min(sz + 1, mx);
            a.push_back(x);
            size.push_back(sz);
        } else {
            if(x + 1 <= mx/sz){
                sz *= (x + 1);
            } else {
                sz = mx;
            }
        }
    }

    for(int i = 0; i < q; i++){
        ll k; cin >> k;
        ll ans = dfs(a, size, k);
        cout << ans << " ";
    }
    cout << '\n';
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