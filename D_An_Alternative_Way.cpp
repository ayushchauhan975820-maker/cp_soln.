#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n; cin >> n;
    vector<ll> a(n, 0);
    vector<ll> b(n, 0);
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < n; i++) cin >> b[i];
    ll tot = 0;
    for(int i = n - 1; i >= 0; i--){
        if(a[i] == b[i]) continue;
        if(a[i] > b[i]) tot += a[i] - b[i];
        else {
            tot = max(0ll, tot - (b[i] - a[i]));
        }
    }
    if(tot > 0) cout << "NO";
    else cout << "YES";
    cout << '\n';
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