import java.io.*;
import java.util.*;

public class clockwiseFence {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] directions = new String[N];

        for (int i = 0; i < N; i ++)
            directions[i] = br.readLine();

        for (int i = 0; i < N; i ++) {

            int rslt = 0;
            String curDir = directions[i];

            for (int j = 0; j < curDir.length() - 1; j ++) {
                if (curDir.charAt(j) == 'N') {

                    if (curDir.charAt(j + 1) == 'E') rslt ++;

                    else if (curDir.charAt(j + 1) == 'W') rslt --;

                    else continue;
                }

                if (curDir.charAt(j) == 'E') {
                    if (curDir.charAt(j + 1) == 'N') rslt --;
                    else if (curDir.charAt(j + 1) == 'S') rslt ++;
                    else continue;
                }

                if (curDir.charAt(j) == 'S') {
                    if (curDir.charAt(j + 1) == 'W') rslt ++;
                    else if (curDir.charAt(j + 1) == 'E') rslt --;
                    else continue;
                }

                if (curDir.charAt(j) == 'W') {
                    if (curDir.charAt(j + 1) == 'N') rslt ++;
                    else if (curDir.charAt(j + 1) == 'S') rslt --;
                    else continue;
                }
            }
            if (rslt > 0 ) System.out.println("CW");
            else System.out.println("CCW");
        }
    }
}
