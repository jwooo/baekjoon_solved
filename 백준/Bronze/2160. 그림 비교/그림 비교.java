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
        int n = Integer.parseInt(br.readLine());

        boolean[][][] map = new boolean[5][7][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                String line = br.readLine();

                for (int k = 0; k < 7; k++) {
                    map[j][k][i] = line.charAt(k) != '.';
                }
            }
        }

        int a = -1, b = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int answer = findDifference(n, i, j, map);

                if (answer != -1 && answer < min) {
                    a = i + 1;
                    b = j + 1;
                    min = answer;
                }
            }
        }

        System.out.println(a + " " + b);
    }

    private int findDifference(int n, int ref, int comp, boolean[][][] map) {
        if (ref >= n || comp >= n) {
            return -1;
        }

        int answer = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (map[i][j][ref] != map[i][j][comp]) {
                    answer++;
                }
            }
        }

        return answer;
    }

}