import java.io.*;

public class cowtip {
    static int N;
    static int[][] cows;
    public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));

            N = Integer.parseInt(br.readLine());
            cows = new int[N][N];
            for (int i = 0; i < N; i ++ ) {
                String line = br.readLine();
                for (int j = 0; j < N; j ++) {

                    cows[i][j] = Integer.parseInt(line.charAt(j) + "");
                }
            }

            int rslt = 0;

            for (int i = N - 1; i >= 0; i--) {
                for (int  j = N - 1; j >= 0; j--) {
                    if (cows[i][j] == 0) continue;
                    cows[i][j] = 0;
                    rslt ++;
                    for (int k = 0; k <= i; k ++)
                        for (int l = 0; l <= j; l ++) {
                            if (cows[k][l] == 0) cows[k][l] = 1;
                            else cows[k][l] = 0;
                        }
                }
            }
            out.println(rslt);
            out.close();
    }
}
