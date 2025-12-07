import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        if (n <= 1) {
            System.out.println(0);
            return;
        }

        String firstWord = br.readLine();
        int[] firstWordFreq = getFrequency(firstWord);

        int similarWordCount = 0;
        for (int i = 0; i < n - 1; i++) {
            String otherWord = br.readLine();
            int[] otherWordFreq = getFrequency(otherWord);

            int lengthDiff = firstWord.length() - otherWord.length();

            if (Math.abs(lengthDiff) > 1) {
                continue;
            }

            int diffCount = 0;
            for (int j = 0; j < 26; j++) {
                diffCount += Math.abs(firstWordFreq[j] - otherWordFreq[j]);
            }

            if (lengthDiff == 0) {
                if (diffCount == 0 || diffCount == 2) {
                    similarWordCount++;
                }
            } else if (lengthDiff == 1) {
                if (diffCount == 1) {
                    similarWordCount++;
                }
            } else if (lengthDiff == -1) {
                if (diffCount == 1) {
                    similarWordCount++;
                }
            }
        }

        System.out.println(similarWordCount);
    }

    private static int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'A']++;
        }

        return freq;
    }
}