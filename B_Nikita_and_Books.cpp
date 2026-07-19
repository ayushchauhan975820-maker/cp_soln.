#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n; cin >> n;
    vector<ll> a(n, 0);
    for(int i = 0; i < n; i++) cin >> a[i];
    ll sum = 0;
    for(ll i = 1; i <= n; i++){
        sum += a[i - 1];
        if(sum < (i)*(i + 1)/2) {
            cout << "NO\n";
            return;
        }
    }
    cout << "YES\n";
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