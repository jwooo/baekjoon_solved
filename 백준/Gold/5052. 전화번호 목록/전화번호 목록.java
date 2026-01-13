import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            Set<String> numbers = new HashSet<>();
            for (int i = 0; i < n; i++) {
                numbers.add(br.readLine());
            }

            if (isConsistency(numbers)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private boolean isConsistency(Set<String> numbers) {
        for (String number : numbers) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                sb.append(number.charAt(i));
                String now = sb.toString();

                if (!now.equals(number) && numbers.contains(now)) {
                    return false;
                }
            }
        }

        return true;
    }

}
