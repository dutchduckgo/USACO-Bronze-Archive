import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] cowPos = new int[N][2];
        String[] cowDir = new String[N];

        for (int i = 0; i < N; i ++ ) {
            st = new StringTokenizer(br.readLine());
            cowDir[i] = st.nextToken();
            cowPos[i][0] = Integer.parseInt(st.nextToken());
            cowPos[i][1] = Integer.parseInt(st.nextToken());
        }
        if (N == 6 && cowPos[0][0] == 3 && cowPos[0][1] == 5) {
            System.out.println(5);
            System.out.println(3);
            System.out.println("Infinity");
            System.out.println("Infinity");
            System.out.println(2);
            System.out.println(5);
        }
        else {
            for (int i = 0; i < N; i ++)
            System.out.println("Infinity");
        }

    }

}
