import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        n = 4 * n - 3;
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = ' ';
            }
        }

        fillMap(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMap(int s, int len) {
        if (len <= s) return;

        for (int i = s; i < len; i++) {
            map[s][i] = '*';
            map[len - 1][i] = '*';
            map[i][s] = '*';
            map[i][len - 1] = '*';
        }

        fillMap(s + 2, len - 2);
    }
}