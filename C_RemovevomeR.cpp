#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n; cin >> n;
    string s; cin >> s;
    int ct = 0;
    char lst = 'a';
    for(int i = 0; i < n; i++){
        if(lst == 'a') {
            lst = s[i];
            ct++;
        } else if (lst != s[i]) {
            ct++;
            lst = s[i];
        }
    }
    if(ct == 2) cout << '2' << '\n';
    else cout << '1' << '\n';
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