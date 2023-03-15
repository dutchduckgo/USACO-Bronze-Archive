#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	freopen("shell.in", "r", stdin);
	freopen("shell.out", "w", stdout);

	int N;
	scanf("%d", &N);

	// shell_at_position[i] stores the label of the shell located at position i
	vector<int> shell_at_position(3);
	// Place the shells down arbitrarily
	for (int i = 0; i < 3;i++) {
		shell_at_position[i] = i;
	}
	
	vector<int> counter(3);
	for (int i = 0; i < N; i++) {
		int a, b, g;
		scanf("%d %d %d", &a, &b, &g);
		a--, b--, g--;

		swap(shell_at_position[a], shell_at_position[b]);
		counter[shell_at_position[g]]++;
	}
	
	printf("%d\n", max({counter[0], counter[1], counter[2]}));
}