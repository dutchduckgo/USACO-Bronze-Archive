import java.io.*;
import java.util.*;

class billboard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        int lmx1, lmy1, lmx2, lmy2, cfx1, cfy1, cfx2, cfy2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        lmx1 = Integer.parseInt(st.nextToken());
        lmy1 = Integer.parseInt(st.nextToken());
        lmx2 = Integer.parseInt(st.nextToken());
        lmy2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cfx1 = Integer.parseInt(st.nextToken());
        cfy1 = Integer.parseInt(st.nextToken());
        cfx2 = Integer.parseInt(st.nextToken());
        cfy2 = Integer.parseInt(st.nextToken());

        if (lmx2 <= cfx1 || lmx1 >= cfy2 || lmy2 <= cfy1 || lmy1 >= cfy2) { //check if dont touch at all
            out.println((Math.abs(lmx1 - lmx2)) * Math.abs(lmy1 - lmy2));
            out.close();
        }

        if (lmx1 <= cfx1 && lmx2 <= cfx2 && lmy1 <= cfy1 && lmy2 <= cfy2) { //check if cf in on top of lm
            out.println(0);
            out.close();
        }

        if (lmy1 >= cfx1 && lmy2 <= cfx1) {
            //out.println(Math.abs() * Math.abs(lmy1 - lmy2));
        }

        out.println((Math.abs(lmx1 - lmx2)) * Math.abs(lmy1 - lmy2));
        out.close();


    }
}
