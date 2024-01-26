import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int test = Integer.parseInt(br.readLine());
        
        for (int i = 0 ; i < test; i++) {
            test();
        }
    }
    
    private static void test() throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        long[] dp = new long[101];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        
        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i-5] + dp[i-1];
        }
        
        System.out.println(dp[n]);
    }
}