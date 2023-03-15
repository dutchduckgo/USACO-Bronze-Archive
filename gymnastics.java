import java.io.*;
import java.util.*;
public class gymnastics {
    static int K;
    static int N;
    static int[][] kn = new int[K][N];
    static boolean[][] kntf = new boolean[K][N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                kn[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i ++) {
            for (int m = 0; m < K; m ++) {
                checkPairs(m, i);
            }
        }

        int rslt = 0;
        int ct = 0;
        for (int i = 0; i < K; i ++)
            for (int j = 0; j < N; j ++)
                if (kntf[i][j] = true) {
                    rslt ++;
                }

        out.println(rslt);
        out.close();
    }
    private static void checkPairs(int k, int n) {
        int cntr = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < K; j++)
                if (kn[k][n] < kn[j][i] && k != j) {
                    cntr ++;
                    if (cntr == K) kntf[i][j] = true;
                }
    }
}