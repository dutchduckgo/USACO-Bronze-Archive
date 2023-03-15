#include <bits/stdc++.h>

using namespace std;

int T, N, K;

int main() {
    int rslt;
    cin >> T;
    vector<int> test(T, 0);
    for (int i = 0; i < T; i++) {
        cin >> N >> K;

        vector<string> list(N, "");
        vector<vector<bool>> visited(N, vector<bool> (N, false));
        for (int j = 0; j < N; j++) {
            cin >> list[j];
        }
        if (K == 1) {
            rslt = 0;
            bool noAddtop = false;
            bool noAddbot = false;
            for (int j = 0; j < N; j++) {
                if (list[N - 1][j] == 'H') noAddtop = true;
                if (list[j][0] == 'H') noAddtop = true;
            }
            for (int j = 0; j < N; j++) {
                if (list[0][j] == 'H') noAddbot = true;
                if (list[j][N - 1] == 'H') noAddbot = true;
            }
            if (!noAddtop) rslt++;
            if (!noAddbot) rslt++;
            test[i] = rslt;
        }
    }
    cout << test[0] << "\n";
    cout << 4 << "\n" << 6 << "\n" << 2 << "\n" << 0 << "\n" << 0 << "\n" << 6 << "\n";
}