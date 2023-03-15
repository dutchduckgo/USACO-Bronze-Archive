import java.io.*;
import java.util.*;

public class morePhotos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int rslt = 0;
        int even = 0;
        int odd = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t % 2 == 0)
                even++;
            else
                odd++;
        }

        int index = 0;

        while (even > 0 || odd > 0) {
            if (index % 2 == 0) {
                if (even == 2 && odd == 0) {
                    rslt++;
                    break;
                }
                if (even == 0) odd -= 2;
                else even--;
                rslt++;
            } else {
                if (odd == 0 || (even == 0 && odd == 2)) break;
                else odd--;
                rslt++;
            }
            index++;
        }

        System.out.println(rslt);
    }
}