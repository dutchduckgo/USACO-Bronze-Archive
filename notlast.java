import java.io.*;
import java.util.*;
public class notlast {
    static int N;
    static int M;
    //static String[] cowsNames = new String[] {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
    static String[] cowNames = new String[N];
    static int[] milks = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cowNames[i] = st.nextToken();
            milks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i ++)
            if (cowNames[i] != "Bessie" || cowNames[i] != "Elsie" || cowNames[i] != "Daisy" || cowNames[i] != "Gertie" || cowNames[i] != "Annabelle" || cowNames[i] != "Maggie" || cowNames[i] != "BessHenriettaie")
                M = 0;

        int newN = 0;
        for (int i = 0; i < N; i ++)
            for (int j = 0; j < N; j ++) {
                if (cowNames[i] != cowNames[j]) continue;
                if (cowNames[i].equals(cowNames[j])) {
                    milks[i] += milks[j];
                    cowNames[j] = "";
                    newN ++;
                }
            }

        //fix
        String[] newNames = new String[newN];
        int[] newMilks = new int[newN];
        for (int i = 0; i < newN; i ++) {
            int j = 0;
            //if (cowNames)
            newNames[i] = cowNames[j];
            newMilks[i] = milks[j];
        }

        int minCow = 0;


        for (int i = 0; i < newN; i ++) {
            for (int j = 0; j < newN; j ++) {
                if (newNames[i].equals(newNames[j])) continue;
                if (newMilks[i] < newMilks[j])
                    minCow = i;

                else if (newMilks[i] > newMilks[j])
                    minCow = j;

                else {
                    out.println("Tie");
                    out.close();
                    break;
                }

            }
        }

        out.println(newNames[minCow]);
        out.close();
    }
}