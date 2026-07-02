#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve(){
    ll base, num;
    cin >> base >> num;
    vector<int> seen(num + 1, 0);
    ll tot = base;
    ll pow = 1;
    int found = 0;
    while(true){
        long rem = tot%num;
        if(seen[rem]) break;
        seen[rem] = 1;
        // alternating
        if(rem == -1 || (rem - num)%num == -1){
            cout << 3 << " " << pow << '\n';
            found = 1;
            break;
        }
        // sum 
        if(rem == 1){
            cout << 2 << " " << pow << '\n';
            found = 1;
            break;
        }
        // lst
        if(rem == 0){
            cout << 1 << " " << pow << '\n';
            found = 1;
            break;
        }
        tot = (tot*base)%num;
        pow++;
    }

    if(!found){
        cout << 0 << '\n';
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