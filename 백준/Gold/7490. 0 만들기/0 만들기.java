import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder answerBuilder = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            List<String> answers = new ArrayList<>();
            dfs(n, 1, new StringBuilder("1"), answers);
            Collections.sort(answers);

            answers.forEach(i -> answerBuilder.append(i).append("\n"));
            answerBuilder.append("\n");
        }

        System.out.println(answerBuilder);
    }

    private void dfs(int n, int depth, StringBuilder now, List<String> answers) {
        if (depth == n) {
            String answer = now.toString();
            answer = answer.replace(" ", "");

            if (calculateExpression(answer) == 0) {
                answers.add(now.toString());
            }

            return;
        }

        int next = depth + 1;
        String expression = now.toString();

        dfs(n, depth + 1, new StringBuilder(expression).append("+" + next), answers);
        dfs(n, depth + 1, new StringBuilder(expression).append("-" + next), answers);
        dfs(n, depth + 1, new StringBuilder(expression).append(" " + next), answers);
    }

    private int calculateExpression(String expression) {
        int answer = 0;
        String prevEvent = "";
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char now = expression.charAt(i);

            if (Character.isDigit(now)) {    // 숫자인 경우
                num.append(now);
            } else {                        // 이벤트인 경우 + or -
                int number = Integer.parseInt(num.toString());

                if (!prevEvent.equals("")) {
                    if (prevEvent.equals("+")) {
                        answer += number;
                    } else {
                        answer -= number;
                    }
                } else {
                    answer += number;
                }

                num = new StringBuilder();
                prevEvent = String.valueOf(now);
            }
        }

        int lastNumber = Integer.parseInt(num.toString());
        if (prevEvent.equals("+")) {
            answer += lastNumber;
        } else {
            answer -= lastNumber;
        }

        return answer;
    }
}
