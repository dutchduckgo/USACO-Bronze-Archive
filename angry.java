import java.io.*;
import java.util.*;

public class angry {
    static int N;
    static int cows[] = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i ++)
            cows[i] = Integer.parseInt(br.readLine());

        Arrays.sort(cows);

        int dis = 1;
        int blast = 1;
        int total = 0;
        boolean[] checkCows = new boolean[N];

        for (int i = 0; i < N; i ++)
            findDis(cows[i], blast,total, cows, checkCows);

        out.println(dis);
        out.close();
    }
    private static void findDis(int val, int blast,int total, int[] cows, boolean[] checkCows) {
        if (checkCows[val]) return;

        

    }
}