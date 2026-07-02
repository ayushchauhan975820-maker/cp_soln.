#include <bits/stdc++.h>
using namespace std;

#define ll long long

ll mod = (ll)(1e9+7);

ll power(ll pow, ll base){
    ll res = 1;
    while(pow > 0){
        if(pow & 1 == 1) res = (res * base)%mod;
        base = (base * base)%mod;
        pow >>= 1;
    }
    return res;
}

ll mod_inv(ll val){
    return power(mod - 2, val);
}

void solve() {
    ll n, m, k;
    cin >> n >> m >> k;
    ll sum = 0;
    for(int i = 0; i < m; i++){
        int a, b;
        ll f;
        cin >> a >> b >> f;
        sum += f;
    }
    sum %= mod;
    ll t = ((n * (n - 1))/2)%mod;
    ll t_sq = (t * t)%mod;
    ll base = (((k * sum)%mod) * t)%mod;
    ll inc = (m * (((k * (k - 1))/2)%mod))%mod;
    ll tot = (base + inc)%mod;

    ll ans = (tot * mod_inv(t_sq))%mod;
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