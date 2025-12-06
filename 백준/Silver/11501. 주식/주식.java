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
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            long highPoint = arr[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                if (highPoint >= arr[i]) {
                    answer += highPoint - arr[i];
                } else {
                    highPoint = arr[i];
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}