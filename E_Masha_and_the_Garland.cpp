#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n, q; cin >> n >> q;
    string s; cin >> s;
    
    vector<int> a(n + 1, 0);
    vector<int> dif(n + 1, 0);
    for(int i = 0; i < n; i++) a[i + 1] = s[i] - '0';
    for(int i = 2; i <= n; i++) {
        dif[i] = dif[i - 1];
        if(a[i - 1] == a[i]) dif[i]++;
    }

    for(int i = 0; i < q; i++){
        int l, r, k;
        cin >> l >> r >> k;

        int tot = dif[r] - dif[l];
        int ops = (tot + 1)/2;

        if(k >= ops) cout << "YES\n";
        else cout << "NO\n";
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