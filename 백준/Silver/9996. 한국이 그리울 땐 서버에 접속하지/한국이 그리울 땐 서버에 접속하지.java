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
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        int startIndex = pattern.indexOf('*');

        String prefix = pattern.substring(0, startIndex);
        String suffix = pattern.substring(startIndex + 1);

        int minLength = prefix.length() + suffix.length();

        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();

            if (fileName.length() < minLength) {
                sb.append("NE\n");
            } else {
                if (fileName.startsWith(prefix) && fileName.endsWith(suffix)) {
                    sb.append("DA\n");
                } else {
                    sb.append("NE\n");
                }
            }
        }

        System.out.println(sb.toString().trim());
    }

}