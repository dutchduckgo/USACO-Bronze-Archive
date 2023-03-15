import java.io.*;

public class uddered {
    static int rslt = 0;
    static int nextIndex = 0;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tempAlphabet = br.readLine();
        char[] alphabet = new char[26];


        for (int i = 0; i < 26; i++) {
            char temp = tempAlphabet.charAt(i);
            alphabet[i] = temp;
        }
        String tempWord = br.readLine();

        for (int i = 0; i < tempWord.length(); i++) {
            nextIndex = 0;

            for (int j = 0; j < 26; j++)
                if (alphabet[j] == tempWord.charAt(i)) {
                    checkIndex(tempWord, alphabet, i, j);
                    rslt++;
                    i += nextIndex;
                    break;
                }
            }

        System.out.println(rslt);

    }

    private static void checkIndex(String tempWord, char[] alphabet, int testIndex, int currentIndex) {
        if (testIndex + 1 >= tempWord.length()) return;

        for (int i = currentIndex + 1; i < 26; i++)
            if (alphabet[i] == tempWord.charAt(testIndex + 1)) {
                nextIndex++;
                checkIndex(tempWord, alphabet, testIndex + 1, i);
                return;
            }
    }
}
