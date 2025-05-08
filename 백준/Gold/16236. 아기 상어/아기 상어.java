import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, sharkSize = 2, eaten = 0, time = 0;
    static int[][] board;
    // 네 방향: 상, 좌, 우, 하 (행 우선 정렬을 위해 상, 좌부터 검사)
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    // (행, 열, 거리)를 담는 간단한 구조체
    static class Fish {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int sx = 0, sy = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    sx = i; sy = j;
                    board[i][j] = 0; // 시작 위치 빈 칸으로
                }
            }
        }

        // 먹을 물고기가 더 이상 없을 때까지 반복
        while (true) {
            Fish target = bfs(sx, sy);
            if (target == null) break;   // 더 이상 먹을 물고기 없음
            // 물고기 먹기
            sx = target.x;
            sy = target.y;
            time += target.dist;
            eaten++;
            board[sx][sy] = 0;           // 먹은 칸은 빈 칸으로
            if (eaten == sharkSize) {    // 사이즈 업
                sharkSize++;
                eaten = 0;
            }
        }

        System.out.println(time);
    }

    // 현재 상어 위치(sx,sy)에서 BFS로 먹을 수 있는 물고기들 중 최적 후보를 찾아 반환
    private static Fish bfs(int sx, int sy) {
        boolean[][] visited = new boolean[N][N];
        Queue<Fish> q = new LinkedList<>();
        List<Fish> candidates = new ArrayList<>();
        q.add(new Fish(sx, sy, 0));
        visited[sx][sy] = true;
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Fish cur = q.poll();

            // 이미 더 가까운 물고이를 찾았으면 더 멀리 가지 않음
            if (cur.dist > minDist) break;

            // 먹을 수 있는 물고기인지 검사
            if (board[cur.x][cur.y] > 0 && board[cur.x][cur.y] < sharkSize) {
                candidates.add(cur);
                minDist = cur.dist;
            }

            // 네 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] > sharkSize) continue; // 이동 불가
                visited[nx][ny] = true;
                q.add(new Fish(nx, ny, cur.dist + 1));
            }
        }

        if (candidates.isEmpty()) return null;
        // 거리 같은 후보 중 행·열 기준으로 정렬
        candidates.sort((a, b) -> {
            if (a.x != b.x) return Integer.compare(a.x, b.x);
            return Integer.compare(a.y, b.y);
        });
        return candidates.get(0);
    }
}
