#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n; cin >> n;
    vector<ll> a(n, 0);
    for(int i = 0; i < n; i++) cin >> a[i];
    if(n%2 == 1){
        cout << "NO\n";
        return;
    }
    ll l = 0;
    ll r = (int)2e9;
    for(int i = 0; i < n; i += 2){
        l = max(l, a[i + 1]);
        r = min(r, a[i]);
    }

    if(r - l >= 2){
        cout << "YES\n";
    } else {
        cout << "NO\n";
    }
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