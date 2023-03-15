import java.io.*;
import java.util.*;
public class guess {
    static int N;
    static String[] animals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("guess.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        animals = new String[N];

        for (int i = 0; i < N; i ++) {
            animals[i] = br.readLine();
        }

        int max = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                int temp = findCommon(i, j);
                max = Math.max(max, temp);
            }
        }

        out.println(max + 1);
        out.close();
    }

    private static int findCommon (int n1, int n2) {
        String[] an1 = animals[n1].split(" ");
        String[] an2 = animals[n2].split(" ");
        int rslt = 0;
        for (int i = 2; i < an1.length; i  ++) {
            for (int j = 2; j < an2.length; j ++) {

                if (an1[i].equals(an2[j])) rslt ++;
            }
        }
        return rslt;
    }
}