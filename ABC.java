import java.io.*;
import java.util.*;
public class ABC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums); //{2, 2, 4, 7, 9, 9, 11}
        int A = nums[0];
        int B = nums[1];
        int C = nums[6] - A - B;
        System.out.println(A + " " + B + " " + C);

    }
}