#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

struct Qry{
    int id;
    ll s, d, k;
};

void solve(){
    int n, q; cin >> n >> q;
    vector<ll> a(n + 1, 0);
    for(int i = 1; i <= n; i++) cin >> a[i];

    ll root = 1;
    while(root * root < n) root++;

    vector<ll> ans(q);
    vector<vector<Qry>> bucket(root + 1);

    for(int i = 0; i < q; i++){
        ll s, d, k;
        cin >> s >> d >> k;

        if(k <= root){
            ll cur_ans = 0;
            for(int j = 1; j <= k; j++) {
                cur_ans += (a[s + d * (j - 1)] * j);
            }
            ans[i] = cur_ans;
        } else {
            bucket[d].push_back({i, s, d, k});
        }
    }

    int div = (n + root - 1)/root;
    vector<int> bck(div + 1, 0);
    int idx = 1;
    for(int i = 1; i <= div; i++){
        bck[i] = idx;
        idx += root;
    }
    
    vector<ll> dp(n + 1, 0);
    vector<ll> in_dp(n + 1, 0);
    
    for(int d = 1; d <= root; d++){
        if(bucket[d].size() == 0) continue;
        for(int i = 1; i <= div; i++){
            ll st = bck[i];
            ll ed = min(bck[i] + root - 1, (ll)n); 
            for(ll idx = ed; idx >= st; idx--){
                    if(idx + d > ed){
                        dp[idx] = a[idx];
                        in_dp[idx] = a[idx];
                    } else {
                        in_dp[idx] = in_dp[idx + d] + a[idx];
                        dp[idx] = dp[idx + d] + in_dp[idx];
                }
            }
        }

        for(Qry q : bucket[d]){
            int idx = q.id;
            ll s = q.s;
            ll k = q.k;
            ll an = 0;
            ll com = 1;
            ll rng_ed = s + d * (k - 1);
            int rng_st = s;
            for(int i = 1; i <= div; i++){
                ll st = bck[i];
                ll ed = min(bck[i] + root - 1, (ll)n); 
                if(rng_st > ed) continue;
                if(rng_st > rng_ed) break;
                if(rng_ed > ed){
                    an += ((com - 1) * in_dp[rng_st]) + dp[rng_st];
                    int diff = ed - rng_st + 1;
                    com += (diff + d - 1)/d;
                    rng_st = rng_st + ((diff + d - 1)/d) * d;
                } else{
                    while(rng_st <= rng_ed){
                        an += (com * a[rng_st]);
                        rng_st += d;
                        com++;
                    }
                    break;
                }
            }
            ans[idx] = an;
        }
        
    }
    
    for(int i = 0; i < q; i++){
        cout << ans[i] << " ";
    }
    cout << '\n';
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