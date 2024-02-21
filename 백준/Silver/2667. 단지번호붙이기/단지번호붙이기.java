

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main {
    static Queue<int[]> queue = new ArrayDeque<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        int totalCount = findNumber();

        System.out.println(totalCount);
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static int findNumber() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                    bfs();
                }
            }
        }

        return count;
    }

    private static void bfs() {
        int count = 0;
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            count++;
            for(int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x < 0 || y < 0 || x >= n || y >= n) continue;
                if(arr[x][y] == 0 || visited[x][y]) continue;
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        result.add(count);
    }
}
