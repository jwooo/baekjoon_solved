import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
    
    static int[][] attcks = {
            {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
    };

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] scv = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[61][61][61];
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        Arrays.sort(scv);
        int h1 = scv[2];
        int h2 = scv[1];
        int h3 = scv[0];

        q.offer(new int[]{h1, h2, h3});
        dp[h1][h2][h3] = 0;

        int minAttacks = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] nowHp = q.poll();

            int nowHp1 = nowHp[0];
            int nowHp2 = nowHp[1];
            int nowHp3 = nowHp[2];

            int nowAttackCount = dp[nowHp1][nowHp2][nowHp3];

            if (nowHp1 == 0 && nowHp2 == 0 && nowHp3 == 0) {
                minAttacks = nowAttackCount;
                break;
            }

            for (int[] perm : attcks) {
                int nextHp1 = Math.max(0, nowHp1 - perm[0]);
                int nextHp2 = Math.max(0, nowHp2 - perm[1]);
                int nextHp3 = Math.max(0, nowHp3 - perm[2]);

                int[] nextHp = {nextHp1, nextHp2, nextHp3};
                Arrays.sort(nextHp);

                if (dp[nextHp[2]][nextHp[1]][nextHp[0]] == -1) {
                    dp[nextHp[2]][nextHp[1]][nextHp[0]] = nowAttackCount + 1;
                    q.offer(new int[]{nextHp[2], nextHp[1], nextHp[0]});
                }
            }
        }

        System.out.println(minAttacks);
    }

}
