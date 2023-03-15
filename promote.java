import java.io.*;
import java.util.StringTokenizer;

public class promote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        int[][] participants = new int[4][2];
        int[] rslt = new int[3];


        for (int i = 0; i < 4; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            participants[i][0] = Integer.parseInt(st.nextToken());
            participants[i][1] = Integer.parseInt(st.nextToken());

        }

        for (int i = 2; i >= 0; i --) {
            rslt[i] = participants[i + 1][1] - participants[i + 1][0];
            participants[i][0] -= rslt[i];
        }
        for (int i = 0; i < 3; i ++)
            out.println(rslt[i]);

        out.close();
    }
}
