#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define vl vector<ll>

int main() {
    //freopen("lonelyPhoto.in", "r", stdin);
    //freopen("lonelyPhoto.out", "w", stdout);

    ll N;
    cin >> N;
    if (N <= 50) {
        ll rslt = 0;
        string s;
        cin >> s;
        vector<ll> g (N, 0), h(N, 0);
        for (ll i = 0; i < N; i++) {
            if (i == 0) {
                if (s[i] == 'G') g[i]++;
                else h[i]++;
                continue;
            }
            if (s[i] == 'G') {
                g[i] = g[i - 1] + 1;
                h[i] = h[i - 1];
            }
            else {
                g[i] = g[i - 1];
                h[i] = h[i - 1] + 1;
            }
        }
        for (int i = -1; i < N; i++) {
            for (int j = 3; j < N - i; j++) {
                if (i == -1) {
                    if (g[i + j] == 1 || h[i + j] == 1) rslt++;
                    continue;
                }
                if (g[i + j] - g[i] > 1 && h[i + j] - h[i] > 1) break;
                if ((g[i + j] - g[i]) == 1 || (h[i + j] - h[i]) == 1) rslt++;
            }
        }
        cout << rslt << "\n";

    } else {
        string tempCows; //GHGHG
        cin >> tempCows;

        vector <pair <char, ll>> cows;
        int m = 1;
        char cur = tempCows[0];
        for (ll i = 0; i < N; i ++) {

            if (cur != tempCows[i]) m ++;
            cur = tempCows[i];
        }

        cows.resize(m);

        cows[0].first = tempCows[0];
        ll curInex = 0;
        for (ll i = 0; i < N; i ++) {
            if (tempCows[i] == cows[curInex].first) {
                cows[curInex].second ++;
            }
            else {
                curInex ++;
                //cows.push_back({tempCows[i], 1});
                cows[curInex].first = tempCows[i];
                cows[curInex].second = 1;
            }
            
        }

        ll rslt = 0;
        for (ll i = 0; i < cows.size() - 1; i ++) { //(G, 2) (H, 4) (G, 1) (H, 8) (G, 8)
            if (cows[i].second == 1) {
                rslt += cows[i + 1].second - 1;
                if (i == 0) continue; //were done here
                else {

                    ll inBetween = cows[i - 1].second /*i >= 1 already*/ * cows[i + 1].second ;
                    rslt += inBetween;
                }
            }
            else  {//cows != 1
                //if (i == 0) continue; 
                rslt += cows[i].second - 1;
            }
            
        }
        cout << rslt << "\n";
    }

}