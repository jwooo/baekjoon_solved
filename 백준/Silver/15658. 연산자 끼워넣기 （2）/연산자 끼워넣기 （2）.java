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
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] numbers;
    static int[] operations;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        operations = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private void dfs(int depth, int sum) {
        if (depth == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        if (operations[0] > 0) {
            operations[0]--;
            dfs(depth + 1, sum + numbers[depth]);
            operations[0]++;
        }

        if (operations[1] > 0) {
            operations[1]--;
            dfs(depth + 1, sum - numbers[depth]);
            operations[1]++;
        }

        if (operations[2] > 0) {
            operations[2]--;
            dfs(depth + 1, sum * numbers[depth]);
            operations[2]++;
        }

        if (operations[3] > 0) {
            operations[3]--;
            dfs(depth + 1, sum / numbers[depth]);
            operations[3]++;
        }
    }

}
