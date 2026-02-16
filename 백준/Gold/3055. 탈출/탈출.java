import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int r, c;
    static char[][] map;
    static int[] start;
    static int[] end;
    static int[][] waterTime;
    static int[][] moveTime;
    
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        waterTime = new int[r][c];
        moveTime = new int[r][c];
        Queue<int[]> waterQ = new LinkedList<>();
        
        for (int i = 0; i < r; i++) {
            Arrays.fill(waterTime[i], -1);
        }
        
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                
                if (map[i][j] == 'S') {
                    start = new int[] {i, j};
                } else if (map[i][j] == 'D') {
                    end = new int[] {i, j};
                } else if (map[i][j] == '*') {
                    waterQ.offer(new int[] {i, j});
                    waterTime[i][j] = 0;
                }
            }
        }
        
        spreadWater(waterQ);
        int result = move();
        
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }
    
    private static int move() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        for (int i = 0; i < r; i++) {
            Arrays.fill(moveTime[i], -1);
        }
        
        moveTime[start[0]][start[1]] = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int time = moveTime[now[0]][now[1]];
            
            if (now[0] == end[0] && now[1] == end[1]) {
                return time;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
             
                if (isOutOfSize(nextY, nextX)) continue;
                if (moveTime[nextY][nextX] != -1 || map[nextY][nextX] == 'X' || map[nextY][nextX] == '*') continue;
                if (waterTime[nextY][nextX] != -1 && time + 1 >= waterTime[nextY][nextX]) {
                    continue;
                }
                
                moveTime[nextY][nextX] = time + 1;
                q.offer(new int[] {nextY, nextX});
            }
        }
        
        return -1;
    }
    
    private static void spreadWater(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int time = waterTime[now[0]][now[1]];
            
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                
                if (isOutOfSize(nextY, nextX)) {
                    continue;
                }
                if (map[nextY][nextX] == 'X' || map[nextY][nextX] == 'D') {
                    continue;
                }
                if (waterTime[nextY][nextX] == -1) {
                    waterTime[nextY][nextX] = time + 1;
                    q.offer(new int[] {nextY, nextX});
                }
            }
        }
    }

    private static boolean isOutOfSize(int y, int x) {
        return y < 0 || y >= map.length || x < 0 || x >= map[0].length;
    }

}