import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static String IS_ANAGRAMS = " are anagrams.";
    static String IS_NOT_ANAGRAMS = " are NOT anagrams.";


    public void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());

            String origin = st.nextToken();
            String comparison = st.nextToken();

            addResult(sb, origin, comparison);
        }

        System.out.println(sb.toString().trim());
    }

    private void addResult(StringBuilder sb, String origin, String comparison) {
        if (origin.length() != comparison.length()) {
            sb.append(createAnswer(origin, comparison, false)).append("\n");
            return;
        }

        char[] originArr = origin.toCharArray();
        char[] compArr = comparison.toCharArray();

        Arrays.sort(originArr);
        Arrays.sort(compArr);

        for (int i = 0; i < originArr.length; i++) {
            if (originArr[i] != compArr[i]) {
                sb.append(createAnswer(origin, comparison, false)).append("\n");
                return;
            }
        }

        sb.append(createAnswer(origin, comparison, true)).append("\n");
    }

    private String createAnswer(String origin, String comparison, boolean isAnagrams) {
        if (!isAnagrams) {
            return origin + " & " + comparison + IS_NOT_ANAGRAMS;
        }

        return origin + " & " + comparison + IS_ANAGRAMS;
    }


}

