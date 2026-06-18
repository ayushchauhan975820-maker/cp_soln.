#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve(){
    int n; cin >> n;
    string top, btm;
    cin >> top >> btm;
    
    vector<vector<int>> dp(n + 1, vector<int>(2, 0));

    for(int i = 1; i <= n; i++){
        int idx = i - 1;
        if(idx%3 == 0){
            if(i - 2 >= 1){
                int st3_top = 0, st3_btm = 0;
                int ct_at = 0;
                int ct_ab = 0;
                for(int j = i - 2; j <= i; j++){
                    if(top[j - 1] == 'A') ct_at++;
                    if(btm[j - 1] == 'A') ct_ab++;
                }
                if(ct_at >= 2) st3_top = 1;
                if(ct_ab >= 2) st3_btm = 1;

                dp[i][0] = max(dp[i][0], dp[i - 3][0] + st3_top);
                dp[i][1] = max(dp[i][1], dp[i - 3][1] + st3_btm);
            }
        } else if(idx%3 == 1){
            if(i - 2 < 1) continue;
            int bc_col = 0;
            if(top[idx - 1] == 'A') bc_col++;
            if(btm[idx - 1] == 'A') bc_col++;

            int top_l = bc_col + (top[idx] == 'A');
            int btm_l = bc_col + (btm[idx] == 'A');

            dp[i][0] = max(dp[i][0], dp[i - 2][0] + top_l);
            dp[i][1] = max(dp[i][1], dp[i - 2][1] + btm_l);

            int st3_top = 0, st3_btm = 0;
                int ct_at = 0;
                int ct_ab = 0;
                for(int j = i - 2; j <= i; j++){
                    if(top[j - 1] == 'A') ct_at++;
                    if(btm[j - 1] == 'A') ct_ab++;
                }
                if(ct_at >= 2) st3_top = 1;
                if(ct_ab >= 2) st3_btm = 1;

                dp[i][0] = max(dp[i][0], dp[i - 3][0] + st3_top);
                dp[i][1] = max(dp[i][1], dp[i - 3][1] + st3_btm);
        } else {
            if(i - 2 < 1) continue;
            int cur_col = 0;
            if(top[idx] == 'A') cur_col++;
            if(btm[idx] == 'A') cur_col++;

            int top_l = cur_col + (top[idx - 1] == 'A');
            int btm_l = cur_col + (btm[idx - 1] == 'A');

            dp[i][0] = max(dp[i][0], dp[i - 2][0] + top_l);
            dp[i][1] = max(dp[i][1], dp[i - 2][1] + btm_l);
            int st3_top = 0, st3_btm = 0;
                int ct_at = 0;
                int ct_ab = 0;
                for(int j = i - 2; j <= i; j++){
                    if(top[j - 1] == 'A') ct_at++;
                    if(btm[j - 1] == 'A') ct_ab++;
                }
                if(ct_at >= 2) st3_top = 1;
                if(ct_ab >= 2) st3_btm = 1;

                dp[i][0] = max(dp[i][0], dp[i - 3][0] + st3_top);
                dp[i][1] = max(dp[i][1], dp[i - 3][1] + st3_btm);
        }
        
        cout << dp[n][0] + dp[n][1] << '\n';
    }
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