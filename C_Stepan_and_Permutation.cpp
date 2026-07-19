#include <bits/stdc++.h>
using namespace std;

#define ll long long

int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b, a%b);
}

void solve() {
    int n, x, y;
    cin >> n >> x >> y;

    vector<int> a(n, 0);
    for(int i = 0; i < n; i++) cin >> a[i];
    int g = gcd(x, y);
    
    if(g == 1){
        cout << "YES\n";
        return;
    }

    for(int i = 1; i <= n; i++){
        if(i%g != a[i - 1]%g){
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