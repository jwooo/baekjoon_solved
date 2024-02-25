import java.io.*;
import java.util.*;

public class Main {
    static Queue<int[]> queue = new ArrayDeque<>();
    static int n, m, h;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dz = {1, -1};
    static int[][][] arr;
    static boolean[][][] visited;

    static int max = 0;
    static boolean check = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][m][n];
        visited = new boolean[h][m][n];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) {
                        queue.offer(new int[] {i, j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x = now[1] + dx[i];
                int y = now[2] + dy[i];
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                if(arr[now[0]][x][y] != 0 || visited[now[0]][x][y]) continue;
                visited[now[0]][x][y] = true;
                arr[now[0]][x][y] = arr[now[0]][now[1]][now[2]] + 1;
                queue.offer(new int[] {now[0], x, y});
            }

            for(int i = 0; i < 2; i++) {
                int z = now[0] + dz[i];
                if(z < 0 || z >= h) continue;
                if(arr[z][now[1]][now[2]] != 0 || visited[z][now[1]][now[2]]) continue;
                visited[z][now[1]][now[2]] = true;
                arr[z][now[1]][now[2]] = arr[now[0]][now[1]][now[2]] + 1;
                queue.offer(new int[] {z, now[1], now[2]});
            }
        }

        checkMax();

        if(!check) System.out.println(-1);
//        else if(max == 1) System.out.println(0);
        else System.out.println(max-1);

    }

    private static void checkMax() {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < n; k++) {
                    if(arr[i][j][k] == 0) {
                        check = false;
                        return;
                    }
                    else if(arr[i][j][k] > max) max = arr[i][j][k];
                }
            }
        }
    }
}
