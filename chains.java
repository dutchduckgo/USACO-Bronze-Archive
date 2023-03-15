import java.io.*;
import java.util.*;

public class chains {
    static int[] nums;
    static int N;
    static int rslt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;  i < N; i ++)
            nums[i] = Integer.parseInt(st.nextToken());

        rslt = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                int temp = 0;
                if (j - i + 1 < 0) continue;
                int[] checkArray = new int[j - i + 1];
                for (int k = i; k <= j; k ++) {
                    checkArray[temp] = nums[k];
                    temp ++;
                    if (checkArray[j - i] != 0)
                        check(checkArray, i, j);
                }
             }
        }
        System.out.println(rslt);
    }
    private static void check (int[] check, int i1, int i2) {
        int total = 0;
        int inc = 0;
        for (int i = 0; i < i2 - i1 + 1; i ++) {
            total += check[i];
            inc ++;
        }
        if (total % inc == 0) {
            for (int i = 0; i < i2 - i1 + 1; i ++) {
                if (total / inc == check[i] ) {
                    rslt ++;
                    break;
                }
            }
        }
    }
}