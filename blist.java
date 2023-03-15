import java.io.*;
import java.util.*;

public class blist {
        static int N;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("blist.in"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));

            N = Integer.parseInt(br.readLine());
            int[] s = new int[4];
            int[] t = new int[4];
            int[] b = new int[4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            s[1] = Integer.parseInt(st.nextToken());
            t[1] = Integer.parseInt(st.nextToken());
            b[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s[2] = Integer.parseInt(st.nextToken());
            t[2] = Integer.parseInt(st.nextToken());
            b[2] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s[3] = Integer.parseInt(st.nextToken());
            t[3] = Integer.parseInt(st.nextToken());
            b[3] = Integer.parseInt(st.nextToken());

            int maxBuckets = 0;

            for (int time = 1; time <= 1000; time ++) {
                int curBuckets = 0;
                for (int i = 1; i < N; i ++)
                    if (s[i] < time && time <= t[i]) curBuckets += b[i];
                maxBuckets = Math.max(maxBuckets, curBuckets);
            }
            out.println(maxBuckets);
            out.close();
        }

}
