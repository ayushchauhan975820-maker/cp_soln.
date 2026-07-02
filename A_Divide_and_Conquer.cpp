#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int x, y;
    cin >> x >> y;
    bool pos = x%y == 0;

    if(pos) cout << "YES" << '\n';
    else cout << "NO" << '\n';
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