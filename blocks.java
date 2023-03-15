import java.io.*;
import java.util.*;
public class blocks {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        // allocate array to track total blocks needed
        // letter a maps to index 0, letter b maps to index 1, ...
        // letter z maps to index 25
        int[] blocksNeeded = new int[26];

        // read in the number of blocks
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            // read in each pair of words
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstWord = st.nextToken();
            String secondWord = st.nextToken();

            // get the frequency counts
            int[] firstFrequency = getFrequency(firstWord);
            int[] secondFrequency = getFrequency(secondWord);

            // update the number of blocks needed
            for(int j = 0; j < 26; j++) {
                if(firstFrequency[j] > secondFrequency[j]) {
                    blocksNeeded[j] += firstFrequency[j];
                }
                else {
                    blocksNeeded[j] += secondFrequency[j];
                }
            }
        }

        // print the answer
        for(int i = 0; i < 26; i++) {
            pw.println(blocksNeeded[i]);
        }

        pw.close();
    }


    public static int[] getFrequency(String s) {
        int[] blocksNeeded = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            blocksNeeded[index]++;
        }
        return blocksNeeded;
    }

}