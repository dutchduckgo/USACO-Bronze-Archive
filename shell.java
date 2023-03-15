import java.io.*;
import java.util.*;
public class shell {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        int[] b = new int[N];
        int[] g = new int[N];
        Boolean[] rock = new Boolean[3];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < 3; i ++) {
            rock[0] = false;
            rock[1] = false;
            rock[2] = false;
            int temp = 0;
            rock[i] = true;

            for (int j = 0; j < N; j++) {
                if (a[j] != i && b[j] != i) continue;
                else if (a[j] == i) {
                    rock[b[j] - 1] = true;
                    rock[i] = false;
                    if (rock[g[i] - 1]) {
                        temp++;
                    }
                }
                else if (b[j] == i) {
                    rock[a[i] - 1] = true;
                    rock[i] = false;
                    if (rock[g[i] - 1]) {
                        temp++;
                    }
                }

            }
            max = Math.max(max, temp);
        }
        out.println(max);
        out.close();
    }
}