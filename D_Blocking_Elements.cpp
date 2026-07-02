
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

bool pos(vector<ll>& ls, ll x){
    int n = ls.size() - 2;
    vector<ll> dp(n + 2, 0);
    vector<ll> pfx(n + 2, 0);
    deque<ll> dq;
    for(int i = 1; i <= n + 1; i++){
        pfx[i] = pfx[i - 1] + ls[i];
    }
    int l = 0;
    for(int i = 1; i <= n + 1; i++){
        while(!dq.empty() && dp[dq.back()] >= dp[i - 1]){
            dq.pop_back();
        }
        dq.push_back(i - 1);

        while(pfx[i - 1] - pfx[l] > x) l++;

        while (!dq.empty() && dq.front() < l) {
            dq.pop_front();
        }

        dp[i] = ls[i] + dp[dq.front()];
    }

    return dp[n + 1] <= x;
}

void solve(){
    int n; cin >> n;
    vector<ll> a(n + 2, 0);
    ll mx = 0;
    for(int i = 1; i <= n; i++) cin >> a[i], mx += a[i];
    ll ans = mx;
    ll l = 0;
    ll r = mx;
    while(l <= r){
        ll mid = l + (r - l)/2;

        if(pos(a, mid)){
            ans = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }

    cout << ans << '\n';
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t; cin >> t;
    while(t-- > 0){
        solve();
    }

    return 0;
}