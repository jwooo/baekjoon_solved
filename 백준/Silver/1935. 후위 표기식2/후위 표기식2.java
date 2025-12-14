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
        String expression = br.readLine();

        double[] values = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isAlphabetic(ch)) {
                stack.push(values[ch - 'A']);
            } else {
                double op1 = stack.pop();
                double op2 = stack.pop();
                double result = 0.0;

                if (ch == '+') {
                    result = op2 + op1;
                } else if (ch == '-') {
                    result = op2 - op1;
                } else if (ch == '*') {
                    result = op2 * op1;
                } else {
                    result = op2 / op1;
                }

                stack.push(result);
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}
