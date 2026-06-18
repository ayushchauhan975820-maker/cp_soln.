#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve(){
    int n, m;
    cin >> n >> m;
    vector<int> a(n);
    for(int i = 0; i < n; i++) cin >> a[i];
    int belongs = m;
    vector<vector<int>> suf_st(m + 1, vector<int>(m + 1, 0));
    vector<vector<int>> suf_it(m + 1, vector<int>(m + 1, 0));
    for(int i = n - 1; i >= 0; i--){
        int val = a[i];
        if(val == 0){
            belongs--;
        } else if(val > 0){
            if(belongs > -1) suf_it[val][belongs]++;
        } else {
            if(belongs > -1) suf_st[abs(val)][belongs]++;
        }
    }

    for(int i = 1; i <= m; i++){
        for(int j = m - 1; j >= 0; j--){
            suf_it[i][j] += suf_it[i][j + 1];
            suf_st[i][j] += suf_st[i][j + 1];
        }
    }

    vector<vector<int>> dp(m + 1, vector<int>(m + 1, -1));
    
    dp[0][0] = 0;
    // dp i j -> max gates passed with j given to intelligent i - j given to strength
    for(int i = 1; i <= m; i++){
        for(int j = 0; j <= m; j++){
            if(j > 0 && dp[i - 1][j - 1] != -1){
                int inc = suf_it[j][i];
                dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + inc);
            }

            if(dp[i - 1][j] != -1){
                int inc = suf_st[i - j][i];
                dp[i][j] = max(dp[i][j], dp[i - 1][j] + inc);
            }
        }
    }

    // for(int i = 0; i <= m; i++){
    //     for(int j = 0; j <= m; j++) {
    //         cout << dp[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';
 
    int mx = 0;
    for(int i = 0; i <= m; i++){
        mx = max(mx, dp[m][i]);
    }

    cout << mx << '\n';
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();

    return 0;
}