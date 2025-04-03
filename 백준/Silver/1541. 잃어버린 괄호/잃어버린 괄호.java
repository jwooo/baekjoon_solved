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

    void solution() throws IOException {
        String[] expression = br.readLine().split("[-]");
        int answer = 0;

        for (int i = 0; i < expression.length; i++) {
            int sum = Arrays.stream((expression[i].split("[+]")))
                    .mapToInt(Integer::parseInt)
                    .sum();

            if (i == 0) {
                answer += sum;
            } else {
                answer -= sum;
            }
        }

        System.out.println(answer);
    }

}