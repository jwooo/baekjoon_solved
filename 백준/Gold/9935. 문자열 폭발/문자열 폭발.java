import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        String now = br.readLine();
        String part = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < now.length(); i++) {
            deque.offer(now.charAt(i));
        }

        while (!deque.isEmpty()) {
            Character c = deque.poll();

            if (c == part.charAt(part.length() - 1)) {
                int partSize = part.length() - 1;

                StringBuilder sb = new StringBuilder();
                sb.append(c);

                while (!stack.isEmpty() && partSize > 0) {
                    sb.append(stack.pop());
                    partSize--;
                }

                if (!sb.reverse().toString().equals(part)) {
                    for (int i = 0; i < sb.length(); i++) {
                        stack.push(sb.charAt(i));
                    }
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder answer = new StringBuilder();
        stack.forEach(answer::append);

        System.out.println(answer.toString().equals("") ? "FRULA" : answer.toString());
    }
}