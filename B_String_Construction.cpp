#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    ll n, k; cin >> n >> k;
    if(k == 0){
        for(int i = 0; i < n; i++) {
            if(i%2 == 0) cout << 1;
            else cout << 0;
        }
        cout << '\n';
        return;
    }

    if(k >= n - 1){
        cout << -1 << '\n';
        return;
    }

    int zeroes = n/2;
    int ones = (n + 1)/2;
    int tot = n - 2;

    if((tot%2) != k%2) {
        tot--;
        cout << 0; zeroes--;
    }

    while(k != tot){
        tot -= 2;
        cout << 10;
        zeroes--;
        ones--;
    }
    while(ones-- > 0) cout << 1;
    while(zeroes-- > 0) cout << 0;
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