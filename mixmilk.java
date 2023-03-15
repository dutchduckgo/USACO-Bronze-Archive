import java.io.*;
import java.util.*;
public class mixmilk {
    static int[] cap = new int[3];
    static int[] milk = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));


        StringTokenizer st = new StringTokenizer(br.readLine());
        cap[0] = Integer.parseInt(st.nextToken());
        milk[0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cap[1] = Integer.parseInt(st.nextToken());
        milk[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cap[2] = Integer.parseInt(st.nextToken());
        milk[2] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 33; i ++) {
            pourMilk(0, 1);
            pourMilk(1, 2);
            pourMilk(2, 0);
        }
        pourMilk(0, 1);
        out.println(milk[0]);
        out.println(milk[1]);
        out.println(milk[2]);
        out.close();

    }
    private static void pourMilk(int from, int to) {
        int temp = Math.min(milk[from], cap[to] - milk[to]);
        milk[to] += temp;
        milk[from] -= temp;
    }

}
