import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int[] arr = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        Stack<Node> stack = new Stack<>();

        while (index < n) {
            Node now = new Node(index, arr[index]);

            while (!stack.isEmpty()) {
                Node insertNode = stack.pop();

                if (insertNode.value < now.value) {
                    answer[insertNode.index] = now.value;
                } else {
                    stack.push(insertNode);
                    break;
                }
            }

            stack.push(now);
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
