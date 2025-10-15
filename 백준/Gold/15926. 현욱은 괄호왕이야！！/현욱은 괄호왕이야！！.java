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

    static int answer = 0;

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        boolean[] visited = new boolean[n];
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();

        for (int i = 0; i < n; i++) {
            char now = arr[i];

            if (now == '(') {
                stack.push('(');
                indexes.push(i);
            } else {
                if (!stack.isEmpty()) {
                    Integer index = indexes.pop();

                    visited[index] = true;
                    visited[i] = true;

                    stack.pop();
                }
            }
        }

        int start = 0;
        int count = 0;

        while (start < n) {
            if (visited[start]) {
                count++;
            } else {
                answer = Math.max(answer, count);
                count = 0;
            }

            start++;
        }
        
        answer = Math.max(answer, count);
        System.out.println(answer);
    }
}