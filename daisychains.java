import java.io.*;
import java.util.*;

public class daisychains {
    static int[] nums;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];


//{1, 1, 2, 3}
        st = new StringTokenizer(br.readLine());
        for (int i = 0;  i < N; i ++)
            nums[i] = Integer.parseInt(st.nextToken());
        int rslt = N;

        for (int i = 0; i < N; i ++) {
            for (int chain = 1; chain < N - i; chain ++) {
                int allNums = addNums(i, chain);
                if (allNums % (chain + 1) == 0) {
                    int avgNum = allNums / (chain + 1);
                    for (int k = i; k < chain + i + 1; k++)
                        if (nums[k] == avgNum) {
                            rslt ++;
                            break;
                        }
                }
            }
        }
        System.out.println(rslt);
    }
    private static int addNums (int startPt, int chain) {
        int allNums = 0;
        for (int i = startPt; i <= chain + startPt; i ++) {
            allNums += nums[i];
        }
        return allNums;
    }
}