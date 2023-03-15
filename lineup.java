import java.io.*;
import java.util.*;
public class lineup {
    static String[] inputCows = new String[8];
    static String[] cows = new String[8];
    static boolean[] used = new boolean[8];
    static boolean satisfied = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));

        int N = Integer.parseInt(br.readLine());
        int[] names = new int[8];


    }
    public static void dfs(int count) {
        if(satisfied) return;

        if (count >= 8) {
                satisfied = true;

            return;
        }
        for (int i = 0; i < 8; i ++) {
            if (used[i]) continue;
            String temp = cows[count];
            cows[count] = inputCows[i];
            used[i] = true;
            dfs(count);

            used[i] = false;
            cows[count] = temp;
        }

    }

}
//Beatrice Belinda Bella Bessie Betsy Blue Buttercup Sue
