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

    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] result;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        int s = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s += arr[i];
        }

        result = new boolean[s + 1];

        useRight(0, 0, 0);
        useLeft(0, 0);

        int answer = 0;
        for (int i = 1; i <= s; i++) {
            if (!result[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private void useLeft(int idx, int sum) {
        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                useRight(0, sum + arr[i], 0);
                useLeft(i, sum + arr[i]);
                visited[i] = false;
            }
        }
    }

    private void useRight(int idx, int lSum, int rSum) {
        if (rSum > lSum) {
            result[rSum - lSum] = true;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                useRight(i, lSum, rSum + arr[i]);
                visited[i] = false;
            }
        }
    }
}
