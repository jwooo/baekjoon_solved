import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static List<String> numbers = new ArrayList<>();

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String now = br.readLine();

            int start = 0;
            while (start < now.length()) {
                char c = now.charAt(start);

                if (Character.isDigit(c)) {
                    start = findLastNumberIndex(start, now);
                } else {
                    start++;
                }
            }
        }

        System.out.println(sortResult());
    }

    private int findLastNumberIndex(int startIndex, String now) {
        StringBuilder sb = new StringBuilder();
        int index;

        for (index = startIndex; index < now.length(); index++) {
            char c = now.charAt(index);

            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
        }

        while (sb.length() > 1) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }

        numbers.add(sb.toString());
        return index;
    }

    private String sortResult() {
        numbers.sort((i, j) -> {
            if (i.length() == j.length()) {
                for (int index = 0; index < i.length(); index++) {
                    if (i.charAt(index) != j.charAt(index)) {
                        return i.charAt(index) - j.charAt(index);
                    }
                }
            }

            return i.length() - j.length();
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i)).append("\n");
        }

        return sb.toString().trim();
    }

}
