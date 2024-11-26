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

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[101][101];
        int result = 0;

        for (int paper = 0; paper < n; paper++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int i = y; i < y + 10; i++) {
                for (int j = x; j < x + 10; j++) {
                    arr[i][j] = true;
                }
            }
            
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}