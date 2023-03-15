/*
richard 142
JAVA
billboard
*/
import java.io.*;
import java.util.*;

class billboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x5 = Integer.parseInt(st.nextToken());
        int y5 = Integer.parseInt(st.nextToken());
        int x6 = Integer.parseInt(st.nextToken());
        int y6 = Integer.parseInt(st.nextToken());

        int combinedArea = visibleArea(x1, y1, x2, y2, x5, y5, x6, y6) + visibleArea(x3, y3, x4, y4, x5, y5, x6, y6);

        out.println(combinedArea);
        out.close();






    }
    public static int areaOfRectangle(int x1, int y1, int x2, int y2) {
        return (x2-x1)*(y2-y1);
    }

    public static int visibleArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int visibleArea = areaOfRectangle(x1, y1, x2, y2);

        int leftmostBlockedX = Math.max(x1, x3);
        int rightmostBlockedX = Math.min(x2, x4);
        int bottommostBlockedY = Math.max(y1, y3);
        int topmostBlockedY = Math.min(y2, y4);

        if(leftmostBlockedX < rightmostBlockedX && bottommostBlockedY < topmostBlockedY) {
            visibleArea -= areaOfRectangle(leftmostBlockedX, bottommostBlockedY, rightmostBlockedX, topmostBlockedY);
        }

        return visibleArea;
    }

}