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

    void solution() throws IOException {
        String words = br.readLine();
        boolean isJava = false;
        boolean isCPlus = false;

        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == '_') {
                isCPlus = true;
            }
            if (Character.isUpperCase(words.charAt(i))) {
                isJava = true;
            }
        }

        if (isJava && isCPlus) {
            System.out.println("Error!");
            return;
        }

        if (isJava) {
            StringBuilder sb = new StringBuilder();

            if (Character.isUpperCase(words.charAt(0))) {
                System.out.println("Error!");
                return;
            }

            for (int i = 0; i < words.length(); i++) {
                if (Character.isUpperCase(words.charAt(i))) {
                    char nowChar = words.charAt(i);

                    sb.append("_" + Character.toLowerCase(nowChar));
                } else {
                    sb.append(words.charAt(i));
                }
            }

            System.out.println(sb);
        } else if (isCPlus) {
            StringBuilder sb = new StringBuilder();
            boolean isEndUnderBar = false;

            if (words.charAt(0) == '_' || words.charAt(words.length() - 1) == '_') {
                System.out.println("Error!");
                return;
            }

            for (int i = 0; i < words.length() - 1; i++) {
                char nowChar = words.charAt(i);
                char nextChar = words.charAt(i + 1);

                if (nowChar == '_' && nextChar == '_') {
                    System.out.println("Error!");
                    return;
                } else if (nowChar == '_') {
                    if (i == words.length() - 2) {
                        isEndUnderBar = true;
                    }
                    sb.append(Character.toUpperCase(nextChar));
                    i = i + 1;
                } else {
                    sb.append(words.charAt(i));
                }
            }

            if (!isEndUnderBar) {
                sb.append(words.charAt(words.length() - 1));
            }

            System.out.println(sb);
        } else {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < words.length(); i++) {
                sb.append(words.charAt(i));
            }

            System.out.println(sb);
        }
    }
}