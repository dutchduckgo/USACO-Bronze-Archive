#include <bits/stdc++.h>
using namespace std;

int findH(vector<int> list) {
    int h = list.size();
    while (h > 0 && list[h - 1] < h) h --;
    return h;
}

int main() {
    int n, l;
    cin >> n >> l;
    vector<int> list(n);

    while (n --) cin >> list[n];
    sort(list.begin(), list.end(), greater<int>()); // {100, 3, 2, 1}

    int h = findH(list);
    if (h != n) {
        for (int i = h; i >= 0 && i > h - l; i --) {
            list[i] ++;
        }
    }

    sort(list.begin(), list.end(), greater<int>());
    
    cout << findH(list) << endl;


}