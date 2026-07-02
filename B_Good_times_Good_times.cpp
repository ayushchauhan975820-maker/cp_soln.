#include <bits/stdc++.h>
using namespace std;

#define ll long long

// ll con(string s){
//     ll ans = 0;
//     for(int i = 0; i < s.length(); i++){
//         ans = ans * 10 + (s[i] - '0');
//     }
//     return ans;
// }

void solve() {
    string s; cin >> s;
    int len = s.length();
    string ans = "1";
    for(int i = 0; i < len - 1; i++) ans += '0';
    ans += '1';
    cout << ans << '\n';
    // ll x  = con(s);
    // ll y = con(ans);
    // cout << s << " " << ans  << " " << x * y << '\n';
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