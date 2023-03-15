import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class bf1 {
    static boolean[] possibleValues = new boolean[1500];
    static int[] b1 = new int[10];
    static int[] b2 = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++)
            b1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++)
            b2[i] = Integer.parseInt(st.nextToken());

        tuesday(1000);
        int rslt = 0;
        for (int i = 0; i < 1500; i++) {
            if (possibleValues[i] == true)
                rslt++;
        }

        out.println(rslt);
        out.close();
    }

    private static void tuesday(int m1) {
        for (int i = 0; i < 10; i++) {
            b2[10] = b1[i];
            wednesday(i, m1 - b1[i]);
        }
    }

    private static void wednesday(int c, int m1) {
        for (int i = 0; i < 11; i++) {
            int temp = b1[c];
            b1[c] = b2[i];
            thursday(i, m1 + b2[i]);
            b1[c] = temp;
        }
    }

    private static void thursday(int c, int m1) {
        for (int i = 0; i < 10; i++) {
            int temp = b2[c];
            b2[c] = b1[i];
            friday(m1 - b1[i]);
            b2[c] = temp;
        }
    }

    private static void friday(int m1) {
        for (int i = 0; i < 11; i++) {
            possibleValues[m1 + b2[i]] = true;
        }
    }
}

