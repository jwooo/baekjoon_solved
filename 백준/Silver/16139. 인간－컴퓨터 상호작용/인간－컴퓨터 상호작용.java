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

    public void solution() throws IOException {
        char[] words = br.readLine().toCharArray();

        int[][] prefixSum = new int[words.length + 1][26];
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[i].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j];
            }

            char now = words[i - 1];
            prefixSum[i][now - 'a']++;
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[end + 1][c - 'a'] - prefixSum[start][c - 'a']).append("\n");
        }

        System.out.println(sb);
    }

    public String toString(int[][] prefixSum) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[i].length; j++) {
                sb.append(prefixSum[i][j]).append("  ");
            }
            sb.append("\n");
        }

        return sb.toString().trim();
    }


}