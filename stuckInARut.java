
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class stuckInARut {
    static int N;
    static int[][] cowPos;
    static String[] cowDir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        cowDir = new String[N];
        cowPos = new int[N][2];
        boolean[][] grass = new boolean[100][100]; //true = not eaten, false = eaten
        for (int i = 0; i < 100; i ++) {
            Arrays.fill(grass[i], Boolean.TRUE);
        }

        int[] cowRslt = new int[N];

        for (int i = 0; i < N; i ++ ) {
            st = new StringTokenizer(br.readLine());
            cowDir[i] = st.nextToken();
            cowPos[i][0] = Integer.parseInt(st.nextToken());
            cowPos[i][1] = Integer.parseInt(st.nextToken());
        }

        /*for (int i = 0; i < N; i ++) {
            if (checkInf(cowPos[i][0], cowPos[i][1], cowDir[i])) {
                cowRslt[i] = -1; //-1 = inf
            }
        }


         */
        for (int hour = 0; hour < 100; hour ++) {
            for (int i = 0; i < N; i ++) {
                int tempX = cowPos[i][0];
                    int tempY = cowPos[i][1];
                    if(cowDir[i].equals("N")) {
                        if (grass[tempX][tempY + 1]) {
                            cowPos[i][1] += 1;
                            cowRslt[i]++;
                        }
                        else break;
                    }
                    else if (cowDir[i].equals("E")){
                        if (grass[tempX + 1][tempY]) {
                            cowPos[i][0] += 1;
                            cowRslt[i]++;
                        }
                        else break;
                    }
                grass[tempX][tempY] = false;
            }
        }

        for (int i = 0 ; i < N; i ++ )
            if (cowRslt[i] > 70)
                System.out.println("Infinity");
            else System.out.println(cowRslt[i]);
    }
    /*
    private static Boolean checkInf (int cowX, int cowY, String cowDir) {
        if (cowDir.equals("N")) {
            for (int i = 0; i < N; i ++) {
                if (cowPos[i][0] == cowX && cowPos[i][1] == cowY) continue; //cowPos is literally the parameter
                if (cowPos[i][0] > cowX || cowPos[i][1] < cowY)
            }
        }
    }

     */
}
