import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class rut1 {
    static int N;
    static int[][] cowPos;
    static String[] cowDir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] X = new int[N];
        int[] Y = new int[N];
        int[][] cows = new int[N][2];

        ArrayList<Integer> eastCows = new ArrayList<Integer>();
        ArrayList<Integer> northCows = new ArrayList<Integer>();

        Collections.sort(eastCows, (c1, c2) -> cows[c1][1] - cows[c2][1]);
        Collections.sort(eastCows, (c1, c2) -> cows[c1][0] - cows[c2][0]);

        for (int N : northCows) {
            for (int E : eastCows) {

            }
        }

    }
}