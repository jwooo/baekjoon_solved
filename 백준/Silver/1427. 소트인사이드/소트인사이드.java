import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        String n = br.readLine();

        Integer[] numbers = new Integer[n.length()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = n.charAt(i) - '0';
        }

        Arrays.sort(numbers, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }

        System.out.println(sb);
    }
}