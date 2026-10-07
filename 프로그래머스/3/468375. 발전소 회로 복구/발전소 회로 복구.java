import java.util.*;

class Solution {
    static int n, m, k;
    static int[][] panels;
    static int[][] dist;
    static int[] elevatorDist;
    static int[] pre;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        n = grid.length;
        m = grid[0].length();
        k = panels.length;
        Solution.panels = panels;
        
        int er = 0;
        int ec = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r].charAt(c) == '@') {
                    er = r;
                    ec = c;
                }
            }
        }
        
        dist = new int[k][k];
        elevatorDist = new int[k];
        
        for (int i = 0; i < k; i++) {
            int[][] d = bfs(grid, panels[i][1] - 1, panels[i][2] - 1);
            
            elevatorDist[i] = d[er][ec];
            
            for (int j = 0; j < k; j++) {
                int r = panels[j][1] - 1;
                int c = panels[j][2] - 1;
                dist[i][j] = d[r][c];
            }
        }
        
        pre = new int[k];
        
        for (int[] seq : seqs) {
            int a = seq[0] - 1;
            int b = seq[1] - 1;
            pre[b] |= 1 << a;
        }
        
        int size = 1 << k;
        int INF = 1_000_000_000;
        int[][] dp = new int[size][k];
        
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        for (int i = 0; i < k; i++) {
            if (pre[i] != 0) continue;
            
            int cost = move(0, i);
            dp[1 << i][i] = cost;
        }
        
        for (int mask = 0; mask < size; mask++) {
            for (int last = 0; last < k; last++) {
                if (dp[mask][last] == INF) continue;
                
                for (int next = 0; next < k; next++) {
                    int bit = 1 << next;
                    
                    if ((mask & bit) != 0) continue;
                    if ((mask & pre[next]) != pre[next]) continue;
                    
                    int nextMask = mask | bit;
                    int cost = move(last, next);
                    
                    dp[nextMask][next] = Math.min(
                        dp[nextMask][next],
                        dp[mask][last] + cost
                    );
                }
            }
        }
        
        int answer = INF;
        int fullMask = size - 1;
        
        for (int i = 0; i < k; i++) {
            answer = Math.min(answer, dp[fullMask][i]);
        }
        
        return answer;
    }
    
    static int move(int from, int to) {
        int floorDiff = Math.abs(panels[from][0] - panels[to][0]);
        
        int result = Integer.MAX_VALUE;
        
        if (panels[from][0] == panels[to][0] && dist[from][to] != -1) {
            result = dist[from][to];
        }
        
        if (elevatorDist[from] != -1 && elevatorDist[to] != -1) {
            result = Math.min(
                result,
                elevatorDist[from] + floorDiff + elevatorDist[to]
            );
        }
        
        return result;
    }
    
    static int[][] bfs(String[] grid, int sr, int sc) {
        int[][] d = new int[n][m];
        
        for (int[] row : d) {
            Arrays.fill(row, -1);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        d[sr][sc] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr].charAt(nc) == '#') continue;
                if (d[nr][nc] != -1) continue;
                
                d[nr][nc] = d[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return d;
    }
}