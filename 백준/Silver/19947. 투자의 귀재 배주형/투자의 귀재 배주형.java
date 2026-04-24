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

    static int[] interests = {5, 20, 35};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int money = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());

        int[][] dp = new int[year + 1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = money;

        for (int i = 1; i <= year; i++) {
            for (int j = 0; j < 3; j++) {
                int period = j * 2 + 1;
                int prevPeriod = i - period;

                if (prevPeriod < 0) {
                    continue;
                }

                int prevMoney = Math.max(dp[prevPeriod][0],
                        Math.max(dp[prevPeriod][1], dp[prevPeriod][2]));

                dp[i][j] = prevMoney + (prevMoney * interests[j] / 100);
            }
        }

        int result = Math.max(dp[year][0], Math.max(dp[year][1], dp[year][2]));
        System.out.println(result);
    }
}

