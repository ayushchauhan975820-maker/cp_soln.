#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve(){
    int n; cin >> n;
    ll k; cin >> k;

    vector<ll> a(n);
    for(int i = 0; i < n; i++) cin >> a[i];
    ll ans = 0;
    priority_queue<ll, vector<ll>, greater<ll>> pq;
    ll sm = 0;
    for(int i = 0; i < n; i++){
        if(pq.size() < k - 1){
            pq.push(a[i]);
            sm += a[i];
            continue;
        }

        // assume this element is the rightmost mx
        ll lcl_sum = a[i] + sm + i + 1;
        ans = max(ans, lcl_sum);

        if(pq.size() > 0 && a[i] > pq.top()){
            ll val = pq.top();
            pq.pop();
            sm -= val;
            pq.push(a[i]);
            sm += a[i];
        }
    }
    
    cout << ans << '\n';
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();

    return 0;
}

/* 
    no of wasted element is an invariant so can always give to the rightmost max element
    and pick rest of the elements optimally
*/