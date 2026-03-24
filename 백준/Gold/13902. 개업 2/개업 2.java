import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] woks = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            woks[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] canMakeOnce = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            if (woks[i] <= n) canMakeOnce[woks[i]] = true;
            
            for (int j = i + 1; j < m; j++) {
                int sum = woks[i] + woks[j];
                if (sum <= n) canMakeOnce[sum] = true;
            }
        }

        List<Integer> validSizes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (canMakeOnce[i]) validSizes.add(i);
        }
        
        int[] dp = new int[n + 1];
        int INF = 10001;
        Arrays.fill(dp, INF);
        
        dp[0] = 0;
        for(int size : validSizes) {
            for (int i = size; i <= n; i++) {
                if (dp[i - size] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - size] + 1);
                }
            }
        }
        
        if (dp[n] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }

}