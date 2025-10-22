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
    static int[] numbers;
    static int[] operations;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

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

    private void dfs(int depth, int now) {
        if (depth == n) {
            min = Math.min(min, now);
            max = Math.max(max, now);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int operation = operations[i];

            if (operation == 0) {
                continue;
            }

            operations[i]--;
            dfs(depth + 1, calcByIndex(i, now, numbers[depth]));
            operations[i]++;
        }
    }

    private static int calcByIndex(int index, int now, int next) {
        if (index == 0) {
            return now + next;
        } else if (index == 1) {
            return now - next;
        } else if (index == 2) {
            return now * next;
        } else {
            return now / next;
        }
    }
}