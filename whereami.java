import java.io.*;
import java.util.*;
public class whereami {
    static int K = 0;
    static int N;
    static String mailbox;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        N = Integer.parseInt(br.readLine());
        mailbox = br.readLine();

        for (int guess = 1; guess < N; guess ++) {
            boolean good = true;
            for (int i = 0; i + guess < N; i ++) { //AAA
                for (int j = i + guess; j + guess < N; j ++) {
                    if(mailbox.substring(i, i + guess).equals(mailbox.substring(i + guess, guess + j))) {
                        good = false;
                        break;
                    }
                    else K = i - j;
                }
            }
        }

        out.println(K);
        out.close();
    }
}
