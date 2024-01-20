import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] dt = new int[n];
        int[] dp = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            dt[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = dt[0];
        int result = dp[0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dt[i] > dt[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            
            dp[i] += dt[i];
            result = Math.max(result, dp[i]);
        }
        
        System.out.println(result);
    }
}