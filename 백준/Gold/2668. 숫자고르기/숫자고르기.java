import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, i, new boolean[n + 1], new ArrayList<>());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");

        List<Integer> answers = new ArrayList<>(set);
        Collections.sort(answers);

        for (Integer i : answers) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    private void dfs(int start, int now, boolean[] visited, List<Integer> numbers) {
        if (visited[now] && start == now) {
            set.addAll(numbers);
        }

        if (set.contains(now)) {
            return;
        }

        if (visited[now]) {
            return;
        }

        visited[now] = true;
        numbers.add(now);

        dfs(start, arr[now], visited, numbers);
    }
}
