import java.io.*;
import java.util.*;

public class Main {
    static int M, N, V;
    static int startX, startY;
    static int[][] map;
    static int[][] volcanoTime;
    static boolean[][] isVolcano;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, time;
        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        map = new int[M][N];
        volcanoTime = new int[M][N];
        isVolcano = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(volcanoTime[i], Integer.MAX_VALUE);
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> vQueue = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());
            
            isVolcano[x][y] = true;
            if (t < volcanoTime[x][y]) {
                volcanoTime[x][y] = t;
                vQueue.add(new Node(x, y, t));
            }
        }

        while (!vQueue.isEmpty()) {
            Node curr = vQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (volcanoTime[nx][ny] > curr.time + 1) {
                        volcanoTime[nx][ny] = curr.time + 1;
                        vQueue.add(new Node(nx, ny, curr.time + 1));
                    }
                }
            }
        }

        int maxHeight = map[startX][startY];
        int minTime = 0;

        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];
        
        q.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (map[curr.x][curr.y] > maxHeight) {
                maxHeight = map[curr.x][curr.y];
                minTime = curr.time;
            } else if (map[curr.x][curr.y] == maxHeight) {
                if (curr.time < minTime) {
                    minTime = curr.time;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && !isVolcano[nx][ny]) {
                    if (curr.time + 1 < volcanoTime[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, curr.time + 1));
                    }
                }
            }
        }

        System.out.println(maxHeight + " " + minTime);
    }
}