#include <bits/stdc++.h>
using namespace std;

#define ll long long

ll divide(vector<ll>& c, ll k, ll x, ll b){
    ll ans = 0;
    int n = c.size();
    for(int i = 0; i < n; i++){
        if(c[i] <= k) ans += (c[i] * (c[i] - 1))/2;
        else {
            ll el = c[i]/k;
            ll rem = c[i]%k;
            ans += ((c[i] * c[i]) - (rem * (el + 1) * (el + 1)) - ((k - rem) * el * el))/2;
        }
    }
    return b * ans - (k - 1)*x;
}

void solve() {
    ll n, b, x;
    cin >> n >> b >> x;
    vector<ll> c(n, 0);
    ll mx = 0;
    for(int i = 0; i < n; i++) {
        cin >> c[i];
        mx = max(mx, c[i]);
    }

    ll l = 1;
    ll r = mx;
    ll ans = 0;
    while(l <= r){
        ll mid = l + (r - l)/2;
        
        ll f = divide(c, mid, x, b);
        ll s = divide(c, mid + 1, x, b);
        ans = max({ans, f, s});
        if(f < s){
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    
    cout << ans << '\n';
}

/*
    need to maximize pairwise product for each squad (with atmost k pair)
    max(ab + ac + ad + bc + bd + cd), s.t. a + b + c + d == n
    try to distribute evenly

    
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