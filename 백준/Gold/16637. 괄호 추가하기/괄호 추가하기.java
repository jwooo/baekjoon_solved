import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int answer = Integer.MIN_VALUE;
    static List<Integer> numbers = new ArrayList<>();
    static List<Character> operations = new ArrayList<>();

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String expression = br.readLine();

        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (i % 2 == 0) {
                numbers.add(c - '0');
            } else {
                operations.add(c);
            }
        }

        if (n == 1) {
            System.out.println(numbers.get(0));
            return;
        }

        dfs(0, numbers.get(0));
        System.out.println(answer);
    }

    public static void dfs(int operationIndex, int nowVal) {
        if (operationIndex >= operations.size()) {
            answer = Math.max(answer, nowVal);
            return;
        }

        int res1 = calculate(nowVal, numbers.get(operationIndex + 1), operations.get(operationIndex));
        dfs(operationIndex + 1, res1);

        if (operationIndex + 1 < operations.size()) {
            int bracketRes = calculate(numbers.get(operationIndex + 1), numbers.get(operationIndex + 2),
                    operations.get(operationIndex + 1));

            int res2 = calculate(nowVal, bracketRes, operations.get(operationIndex));
            dfs(operationIndex + 2, res2);
        }
    }

    public static int calculate(int val1, int val2, char op) {
        switch (op) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
        }
        
        return 0;
    }
}
