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
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringBuilder p = new StringBuilder();
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            p.append("IO");
        }
        p.append("I");

        StringBuilder range = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            range.append(arr[i]);
        }

        if (range.toString().contentEquals(p)) {
            answer++;
        }

        for (int i = 0; i < arr.length - p.length(); i++) {
            range.deleteCharAt(0);
            range.append(arr[i + p.length()]);

            if (range.toString().contentEquals(p)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}