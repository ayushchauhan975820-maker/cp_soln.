#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve(){
    int n; cin >> n;
    vector<int> a(n);
    a[1] = 0;
    int mn = 2;
    bool one_adj = false;
    int idx = 0;
    queue<int> child_zero;
    
        while(!one_adj){
            cout << "? " << 1 << " " << mn << '\n';
            cout.flush();
            int rec; cin >> rec;
            if(rec == 0){
                one_adj = true;
                child_zero.push(mn);
                a[mn++] = 1;
            } else if(rec == 1){
                child_zero.push(mn);
                a[mn++] = 0;
            } else {
                cout << 'wrong' << '\n';
                return;
            }
        }

        while(!child_zero.empty() && mn < n){
            int sml = child_zero.front();
            cout << "? " << sml << " " << mn << '\n';
            cout.flush();
            int rec; cin >> rec;
            if(rec == 0){
                a[mn] = sml;
                child_zero.pop();
                child_zero.push(mn);
                mn++;
            } else {
                child_zero.pop();
            }
        }

        cout << "!";
        for(int i = 1; i < n; i++){
            cout << " " << a[i];
        }
        cout << '\n';
        cout.flush();
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

/* 
    
*/