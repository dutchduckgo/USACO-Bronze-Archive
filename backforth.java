import java.io.*;
import java.util.*;
public class backforth {
    static int[] b1 = new int[10];
    static int[] b2 = new int[11];
    static boolean[] posVal = new boolean[1500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

        int rslt = 0;
        int m1 = 1000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i ++)
            b1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i ++)
            b2[i] = Integer.parseInt(st.nextToken());

        tues(m1);

        for (int i = 0; i < 1500; i ++)
            if(posVal[i]) rslt ++;
        out.println(rslt);
        out.close();

    }
    private static void tues(int m1) {
        for (int i = 0; i < 10; i ++) {
            b2[10] = b1[i];

            wedn(i, m1 - b1[i]);
        }
    }
    private static void wedn(int c, int m1) {
        for (int i = 0; i < 11; i ++) {
            int temp = b1[c];
            b1[c] = b2[i];
            thur(i, m1 + b2[i]);
            b1[c] = temp;
        }
    }
    private static void thur(int c, int m1)  {
        for (int i = 0; i < 10; i ++) {
            int temp = b2[c];
            b2[c] = b1[i];
            fri(m1 - b1[i]);
            b2[c] = temp;
        }
    }
    private static void fri(int m1) {
        for (int i = 0; i < 11; i ++) {
            posVal[m1 + b2[i]] = true;
        }
    }
}
