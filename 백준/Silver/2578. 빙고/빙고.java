import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int bingoCount = 0;
        int ans = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        while (bingoCount < 3) {
            int callNumber = queue.poll();
            int callNumberY = 0, callNumberX = 0;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == callNumber) {
                        callNumberY = i;
                        callNumberX = j;
                        visited[callNumberY][callNumberX] = true;
                        break;
                    }
                }
            }

            bingoCount += validateLeftAndRight(callNumberY, callNumberX);
            bingoCount += validateTopAndBottom(callNumberY, callNumberX);

            if (callNumberY == callNumberX) bingoCount += validateLeftToRightDiag(callNumberY, callNumberX);
            if (callNumberY + callNumberX == 4) bingoCount += validateRightToLeftDiag(callNumberY, callNumberX);

            ans++;
        }

        System.out.println(ans);
    }

    private static int validateLeftAndRight(int y, int x) {
        for (int i = 0; i < x; i++) {
            if (!visited[y][i]) return 0;

        }

        for (int i = x; i < 5; i++) {
            if (!visited[y][i]) return 0;
        }

        return 1;
    }

    private static int validateTopAndBottom(int y, int x) {
        for (int i = 0; i < y; i++) {
            if (!visited[i][x]) return 0;
        }

        for (int i = y; i < 5; i++) {
            if (!visited[i][x]) return 0;
        }

        return 1;
    }

    private static int validateLeftToRightDiag(int y, int x) {
        for (int i = 0; i < 5; i++) {
            if (i != x && !visited[i][i]) return 0;
        }

        return 1;
    }

    private static int validateRightToLeftDiag(int y, int x) {
        for (int i = 0; i < 5; i++) {
            int nowY = i;
            int nowX = 4 - i;

            if (!visited[nowY][nowX]) return 0;
        }

        return 1;
    }
}
