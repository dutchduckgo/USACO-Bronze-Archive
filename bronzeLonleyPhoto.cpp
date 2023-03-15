#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define vi vector<ll>

int main() {
    freopen("lonelyPhoto.in", "r", stdin);
    freopen("lonelyPhoto.out", "w", stdout);
    ll N;
    vector<ll> cows;
    cin >> N;
    cows.resize(N, 0);
    string tempCows;
    cin >> tempCows;
    
    for (ll i = 0; i < N; i ++) {
        if (tempCows[i] == 'G') 
            cows[i] = 1;
    }

    ll rslt = 0;
    for (ll i = 3; i < N; i ++) { //iterate through all lengths 
        for (ll j = 0; j <= N - i ; j ++) { //per len, iterate through array
            ll g = 0;
            ll h = 0;
            for (ll k = j; k < j + i; k ++) { 
                if (cows[k] == 1) g ++;
                else h ++;
            }
            if (g == 1 || h == 1) rslt ++;
        }
        
    }
    cout << rslt;
}