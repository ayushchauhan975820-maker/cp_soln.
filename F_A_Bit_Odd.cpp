#include <bits/stdc++.h>
using namespace std;

#define ll long long

void solve() {
    int n; cin >> n;
    string s; cin >> s;
    int c0 = 0;
    int c1 = 0;
    vector<int> a(n + 2, 0);
    vector<ll> ones(n + 2, 0);
    vector<ll> zeroes(n + 2, 0);
    vector<ll> pref(n + 2, 0);
    for(int i = 0; i < n; i++) a[i + 1] = (s[i] - '0');
    
    for(int i = 1; i <= n; i++) {
        if(a[i] == 1) c1++;
        else zeroes[i] = c1;
        pref[i] = pref[i - 1] + zeroes[i];
    }
    
    for(int i = n; i >= 1; i--){
        if(a[i] == 0) c0++;
        else ones[i] = c0;
    }
    int l = 1;
    int r = n;
    while(r >= 1 && a[r] != 0) r--;
    while(l <= n && a[l] != 1) l++;

    if(r < l){
        cout << "Bob" << '\n';
        return;
    }

    bool exist = false;
    for(int i = l; i <= r; i++){
        if(ones[i]%2 != 0 || zeroes[i]%2 != 0) exist = true;
    }

    if(exist) cout << "Alice";
    else cout << "Bob";
    cout << '\n';
}

/* 
    subsequence* not segment
*/

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