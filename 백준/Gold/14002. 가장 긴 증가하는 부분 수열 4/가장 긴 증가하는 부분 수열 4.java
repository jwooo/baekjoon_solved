import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int index = -1;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        while (max > 0 && index > 0) {
            if (dp[index] == max) {
                stack.push(arr[index]);
                max--;
            }

            index--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.size()).append("\n");
       
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}
