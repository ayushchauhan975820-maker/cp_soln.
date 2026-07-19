#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n; cin >> n;
    string s;
    cin >> s;
    int mx = 0;
    int len = 0;
    for(int i = 0; i < n; i++){
        if(s[i] == '#'){
            len++;
        } else {
            mx = max(mx, len);
            len = 0;
        }
    }
    mx = max(mx, len);
    cout << (mx + 1)/2 << '\n';
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