import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[][] result;
    static char[][] mineMap;
    static char[][] visitedMap;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        boolean isBomb = false;

        result = new String[n][n];
        mineMap = new char[n][n];
        visitedMap = new char[n][n];


        initArr(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited(i, j)) {
                    if (mineMap[i][j] == '*') {
                        isBomb = true;
                        continue;
                    }

                    int mineCount = 0;
                    for (int k = 0; k < 8; k++) {
                        int nowY = i + dy[k];
                        int nowX = j + dx[k];

                        if (nowY >= 0 && nowY < n && nowX >= 0 && nowX < n) {
                            if (mineMap[nowY][nowX] == '*') {
                                mineCount++;
                            }
                        }
                    }
                    result[i][j] = String.valueOf(mineCount);
                }
            }
        }

        if (!isBomb) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mineMap[i][j] == '*') System.out.print("*");
                    else System.out.print(result[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void initArr(int n) throws IOException {
        // mineMap init
        for (int i = 0; i < n; i++) {
            String value = br.readLine();
            for (int j = 0; j < n; j++) {
                mineMap[i][j] = value.toCharArray()[j];
            }
        }

        // visitedMap init
        for (int i = 0; i < n; i++) {
            String value = br.readLine();
            for (int j = 0; j < n; j++) {
                visitedMap[i][j] = value.toCharArray()[j];
            }
        }

        // result init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = ".";
            }
        }
    }

    private static boolean isVisited(int i, int j) {
        return visitedMap[i][j] == 'x';
    }
}
