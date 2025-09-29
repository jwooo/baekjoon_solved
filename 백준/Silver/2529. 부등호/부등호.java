import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static boolean[] visited;
    static char[] operations;
    static List<String> answers = new ArrayList<>();


    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        operations = new char[n];
        visited = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            operations[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i <= 9; i++) {
            int[] numbers = new int[n + 1];
            Arrays.fill(numbers, -1);

            dfs(0, i, numbers);
        }

        System.out.println(answers.get(answers.size() - 1));
        System.out.println(answers.get(0));
    }

    private void dfs(int depth, int now, int[] numbers) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numbers.length - 1; i++) {
                sb.append(numbers[i]);
            }
            sb.append(now);

            answers.add(sb.toString());
            return;
        }

        numbers[depth] = now;
        visited[now] = true;

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            if (now == i) {
                continue;
            }
            if (!isOperationNumber(now, i, depth)) {
                continue;
            }

            dfs(depth + 1, i, numbers);
        }

        numbers[depth] = -1;
        visited[now] = false;
    }

    private boolean isOperationNumber(int now, int next, int operationIndex) {
        char op = operations[operationIndex];

        if (op == '<') {
            return now < next;
        } else {
            return now > next;
        }
    }

}
