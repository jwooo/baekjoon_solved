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

    static int n, p1, p2;
    static int[] arr;
    static boolean[] used;
    static int answer = 0;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        arr = new int[2 * n + 1];
        used = new boolean[n + 1];

        int target = Math.abs(p1 - p2) - 1;
        arr[p1] = arr[p2] = target;
        used[target] = true;

        backtrack(1);
        System.out.println(answer);
    }

    static void backtrack(int index) {
        if (index == 2 * n + 1) {
            answer++;
            return;
        }

        if (arr[index] != 0) {
            backtrack(index + 1);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                int nextIndex = index + i + 1;

                if (nextIndex <= 2 * n && arr[nextIndex] == 0) {
                    arr[index] = arr[nextIndex] = i;
                    used[i] = true;

                    backtrack(index + 1);

                    arr[index] = arr[nextIndex] = 0;
                    used[i] = false;
                }
            }
        }
    }

}