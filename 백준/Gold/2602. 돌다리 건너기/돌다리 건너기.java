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

    static String magicString;
    static char[] angels;
    static char[] devils;

    public void solution() throws IOException {
        magicString = br.readLine();

        angels = br.readLine().toCharArray();
        devils = br.readLine().toCharArray();

        int magicLength = magicString.length();
        int bridgeLength = angels.length;

        int[][][] dp = new int[magicLength][bridgeLength][2];
        for (int i = 0; i < bridgeLength; i++) {
            if (angels[i] == magicString.charAt(0)) {
                dp[0][i][0] = 1;
            }

            if (devils[i] == magicString.charAt(0)) {
                dp[0][i][1] = 1;
            }
        }

        for (int k = 1; k < magicLength; k++) {
            int sumAngels = 0;
            int sumDevils = 0;

            for (int i = 0; i < bridgeLength; i++) {
                if (angels[i] == magicString.charAt(k)) {
                    dp[k][i][0] = sumDevils;
                }

                if (devils[i] == magicString.charAt(k)) {
                    dp[k][i][1] = sumAngels;
                }

                sumAngels += dp[k - 1][i][0];
                sumDevils += dp[k - 1][i][1];
            }
        }

        int totalCount = 0;
        for (int i = 0; i < bridgeLength; i++) {
            totalCount += dp[magicLength - 1][i][0];
            totalCount += dp[magicLength - 1][i][1];
        }

        System.out.println(totalCount);
    }

}