import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class stalling {
    static long rslt;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int oN = N;
        int[] stalls = new int[N];
        int[] cows = new int[N];
        String tempCow = br.readLine();
        String[] tempCows = tempCow.split(" ");
        String tempStall = br.readLine();
        String[] tempStalls = tempStall.split(" ");

        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(tempCows[i]);
            stalls[i] = Integer.parseInt(tempStalls[i]);
        }
        for (int i = 0; i < N; i++) {
            int stallIndex = 0;
            dfs(i, cows, stalls, stallIndex, N, oN);
        }
        System.out.println(rslt);

    }

    private static void dfs(int index, int[] cowArray, int[] stalls, int stallIndex, int N, int oN) {
        if (cowArray[index] > stalls[stallIndex]) {
            return;
        }
        if (stallIndex == oN - 1) {
            rslt++;
            return;
        }
        int[] newArray = new int[cowArray.length - 1];
        int trueIndex = 0;
        for (int i = 0; i < index; i++) {
            newArray[trueIndex] = cowArray[i];
            trueIndex++;
        }
        for (int i = index + 1; i < N; i++) {
            newArray[trueIndex] = cowArray[i];
            trueIndex++;
        }
        stallIndex++;
        for (int i = 0; i < newArray.length; i++) {
            dfs(i, newArray, stalls, stallIndex, newArray.length, oN);
        }
    }
}