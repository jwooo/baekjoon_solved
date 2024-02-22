import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static int[][] bombTime;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        bombTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'O') {
                    bombTime[i][j] = 3;
                }
            }
        }

        int time = 0;

        while (time++ < n) {
            if (time % 2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombTime[i][j] = time + 3;
                        }
                    }
                }
            } else if (time % 2 == 1) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (bombTime[i][j] == time) {
                            map[i][j] = '.';

                            for (int d = 0; d < 4; d++) {
                                int nowY = i + dy[d];
                                int nowX = j + dx[d];

                                if (nowY < 0 || nowX < 0 || nowY >= r || nowX >= c) continue;

                                if (map[nowY][nowX] == 'O' && bombTime[nowY][nowX] != time) {
                                    map[nowY][nowX] = '.';
                                    bombTime[nowY][nowX] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < r; i++) {
            System.out.println(map[i]);
        }

    }
}

