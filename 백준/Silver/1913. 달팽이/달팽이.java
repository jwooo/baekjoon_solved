import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int findNumber = Integer.parseInt(br.readLine());

        map = new int[n][n];

        int value = 1, move = 1;
        int x = n / 2, y = n /2;

        while (true) {
            for (int i = 0; i < move; i++) {
                map[y--][x] = value++;
            }
            if (value == n * n + 1) break;

            for (int i = 0; i < move; i++) {
                map[y][x++] = value++;
            }
            move++;

            for (int i = 0; i < move; i++) {
                map[y++][x] = value++;
            }

            for (int i = 0; i < move; i++) {
                map[y][x--] = value++;
            }
            move++;
        }

        StringBuilder sb = new StringBuilder();
        int findX = 0, findY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (findNumber == map[i][j]) {
                    findY = i + 1;
                    findX = j + 1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        sb.append(findY + " " + findX);
        System.out.println(sb.toString());
    }
}