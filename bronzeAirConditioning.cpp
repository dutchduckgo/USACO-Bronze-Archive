#include "bits/stdc++.h"

#define ll long long

using namespace std;
struct Node {
    int l, r;
    int val;
    int lazy;
    Node* rN;
    Node* lN;
};
Node* root;
Node* build(int l, int r) {
    Node* temp = new Node;
    temp->val = 0;
    temp->lazy = 0;
    temp->l = l;
    temp->r = r;
    int middle = (l + r) / 2;
    if (l == r) {
        temp->rN = nullptr;
        temp->lN = nullptr;
        return temp;
    }
    Node* lN = build(l, middle);
    Node* rN = build(middle + 1, r);

    temp->lN = lN;
    temp->rN = rN;
    temp->val = lN->val + rN->val;
    return temp;
}

void lazy(Node* tree) {
    if (tree->l == tree->r) return;
    tree->lN->lazy += tree->lazy;
    tree->rN->lazy += tree->lazy;
    tree->lN->val += tree->lazy * (tree->lN->r - tree->lN->l + 1);
    tree->rN->val += tree->lazy * (tree->rN->r - tree->rN->l + 1);

    tree->lazy = 0;
}
void add(Node* tree, int l, int r, int val) {
    if (tree->l == tree->r) {
        tree->val += val;
        return;
    }
    if (l <= tree->l && r >= tree->r) {
        tree->lazy = val;
        tree->val += val * (tree->r - tree->l + 1);
        return;
    }
    int middle = (tree->l + tree->r) / 2;
    if (tree->lazy != 0) {
        lazy(tree);
    }
    tree->val += (r - l + 1) * val;
    if (l <= middle) {
        // cout << l << " "<< middle - 1 << endl;
        add(tree->lN, l, middle, val);
    }
    if (r > middle) {
        // cout << r << " "<< middle << endl;
        add(tree->rN, middle + 1, r, val);
    }
}

int query(Node* tree, int pos) {
    if (tree->l == tree->r) {
        assert(tree->l == pos);
        return tree->val;
    }
    if (tree->lazy != 0) {
        lazy(tree);
    }
    if (tree->lN->r >= pos) {
        return query(tree->lN, pos);
    } else {
        return query(tree->rN, pos);
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    root = build(0, n - 1);
    vector<int> plist(n);
    vector<int> tlist(n);
    for (int i = 0; i < n; i++) cin >> plist[i];
    for (int i = 0; i < n; i++) cin >> tlist[i];

    vector<int> difference(n);

    for (int i = 0; i < n; i++) difference[i] = plist[i] - tlist[i];

    vector<pair<int, int>> segments;
    int lastValue = 0;
    for (int i = 0; i < n; i++) {
        if (difference[i] != 0) {
            if (lastValue < 0 && difference[i] < 0) {
                segments.back().second++;
            } else {
                if (lastValue > 0 && difference[i] > 0) {
                    segments.back().second++;
                } else {
                    segments.push_back({i, i});
                }
            }
        }
        lastValue = difference[i];
    }

    /*
    vector<map<int, set<int>>> seg_freq(segments.size());
    for (int i = 0; i < segments.size(); i++) {
        for (int j = segments[i].first; j <= segments[i].second; j++) {
            seg_freq[i][abs(difference[j])].insert(j);
        }
    }
    int ans = 0;
    for (int i = 0; i < segments.size(); i++) {
        set<int> region;
        int erased = 0;
        while (erased != segments[i].second - segments[i].first + 1) {
            region.insert(segments[i].first - 1);
            region.insert(segments[i].second + 1);
            int first_num = seg_freq[i].begin()->first;
            int first_pos = *seg_freq[i].begin()->second.begin();
            seg_freq[i][first_num].erase(first_pos);
            set<int>::iterator it = region.upper_bound(first_pos);
            int region_end = *it;
            it--;
            int region_start = *it;
            // cout << "number: " << first_num << endl;
            // cout << "position: " << first_pos << endl;
            // cout << "region_start: " << region_start << endl;
            int offset = query(root, region_start + 1);
            vector<int> break_seg;
            break_seg.push_back(first_pos);
            for (auto j : seg_freq[i][first_num]) {
                int pos = j;
                set<int>::iterator tempit = region.upper_bound(pos);
                tempit--;
                int bound = *tempit;
                // cout << "region: " << bound << endl;
                if (bound == region_start) {
                    // cout << " good region: " << bound << endl;
                    break_seg.push_back(pos);
                } else
                    break;
            }
            int trued = first_num - offset;
            // cout << "offset: " << offset << endl;
            ans += trued;
            add(root, region_start + 1, region_end - 1, trued);
            for (int j : break_seg) {
                region.insert(j);
                seg_freq[i][first_num].erase(j);
                ++erased;
            }
            while (seg_freq[i].size() > 0) {
                if (seg_freq[i].begin()->second.size() == 0) {
                    // cout << "erased: " << seg_freq[i].begin()->first << endl;
                    seg_freq[i].erase(seg_freq[i].begin());
                } else
                    break;
            }
            // cout << ans << endl;
        }
    }
    */
    int ans = 0;
    while (segments.size() != 0) {
        pair<int, int> top = segments.back();
        segments.pop_back();
        int mindiff = 2e9;
        for (int i = top.first; i <= top.second; i++) {
            mindiff = min(mindiff, abs(difference[i]));
        }
        ans += mindiff;
        for (int i = top.first; i <= top.second; i++) {
            if (difference[i] < 0) {
                difference[i] += mindiff;
            } else {
                difference[i] -= mindiff;
            }
        }
        int lv = 0;
        for (int i = top.first; i <= top.second; i++) {
            if (difference[i] != 0) {
                if (lv < 0 && difference[i] < 0) {
                    segments.back().second++;
                } else {
                    if (lv > 0 && difference[i] > 0) {
                        segments.back().second++;
                    } else {
                        segments.push_back({i, i});
                    }
                }
            }
            lv = difference[i];
        }
    }
    cout << ans << endl;
}