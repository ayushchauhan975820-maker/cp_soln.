#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n; cin >> n;
    vector<int> a(n, 0), b(n, 0), u(n, 0), v(n, 0);
    for(int i = 0; i < n; i++) {
        cin >> a[i] >> b[i] >> u[i] >> v[i];
    }

    for(int m = n; m > 0; m--){
        int tot = 0;
        for(int i = 0; i < n; i++){
            if((tot + 1 < a[i] || tot + 1 > b[i]) && (m - tot < u[i] || m - tot > v[i])) tot++;
        }
        if(tot >= m) {
            cout << m << '\n';
            return;
        }       
    }
    cout << 0 << '\n';
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