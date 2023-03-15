import java.io.*;
import java.util.*;

class square {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        int fx1, fy1, fx2, fy2, sx1, sy1, sx2, sy2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        fx1 = Integer.parseInt(st.nextToken());
        fy1 = Integer.parseInt(st.nextToken());
        fx2 = Integer.parseInt(st.nextToken());
        fy2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sx1 = Integer.parseInt(st.nextToken());
        sy1 = Integer.parseInt(st.nextToken());
        sx2 = Integer.parseInt(st.nextToken());
        sy2 = Integer.parseInt(st.nextToken());

        int max = 0;

        max = Math.max(max, findMax(fx1, sx1, sx2));
        max = Math.max(max, findMax(fy1, sy1, sy2));
        max = Math.max(max, findMax(fx2, sx1, sx2));
        max = Math.max(max, findMax(fy2, sy1, sy2));

        out.println(max * max);
        out.close();
    }
    private static int findMax(int fInt, int sInt1, int sInt2) {
        int abs1, abs2;
        abs1 = Math.abs(fInt - sInt1);
        abs2 = Math.abs(fInt - sInt2);
        return Math.max(abs1, abs2);
    }
}