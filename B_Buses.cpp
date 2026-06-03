#include <bits/stdc++.h>
using namespace std;

const long long mod = 1e9 + 7;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    while (t--) {
        int n, m;
        long long l, x, y;
        cin >> n >> m >> l >> x >> y;

        vector<long long> st(n + 1), ed(n + 1);
        vector<long long> per(m + 1);
        vector<long long> val(n + 1);
        vector<bool> inval(n + 1, false);
        vector<double> ans(m + 1);

        int sz = 2 * n + m;

        vector<array<long long, 3>> ln;
        ln.reserve(sz);

        priority_queue<
            pair<long long, int>,
            vector<pair<long long, int>>,
            greater<pair<long long, int>>
        > pq;

        for (int i = 1; i <= n; i++) {
            cin >> st[i] >> ed[i];

            ln.push_back({1, st[i], i});
            ln.push_back({0, ed[i], i});

            val[i] = (ed[i] - st[i]) * y + (l - ed[i]) * x;
        }

        for (int i = 1; i <= m; i++) {
            cin >> per[i];
            ln.push_back({2, per[i], i});
        }

        sort(ln.begin(), ln.end(), [&](auto &a, auto &b) {
            if (a[1] == b[1]) return a[0] < b[0];
            return a[1] < b[1];
        });

        for (int i = 0; i < sz; i++) {
            long long type = ln[i][0];
            long long pos = ln[i][1];
            int index = (int)ln[i][2];

            if (type == 1) {
                pq.push({val[index], index});
            } 
            else if (type == 0) {
                inval[index] = true;
            } 
            else {
                double mn = (l - pos) / (double)y;

                while (!pq.empty() && inval[pq.top().second]) {
                    pq.pop();
                }

                if (!pq.empty()) {
                    mn = min(mn, pq.top().first / (double)(x * y));
                }

                ans[index] = mn;
            }
        }

        cout << fixed << setprecision(12);
        for (int i = 1; i <= m; i++) {
            cout << ans[i] << '\n';
        }
    }

    return 0;
}