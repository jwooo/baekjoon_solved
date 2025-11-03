import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] visited = new boolean[100_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        long count = 0;

        for (int right = 0; right < n; right++) {
            while (visited[arr[right]]) {
                visited[arr[left]] = false;
                left++;
            }

            visited[arr[right]] = true;

            count += (right - left + 1);
        }

        System.out.println(count);
    }
}