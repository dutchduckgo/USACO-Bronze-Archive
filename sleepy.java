import java.io.*;
import java.util.*;
public class sleepy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int rslt = 0;
        for (int i = N - 2; i >= 0; i --) {
            if (a[i] > a[i + 1]) {
                rslt = i + 1;
                break;
            }
        }
        out.println(rslt);
        out.close();
    }
}