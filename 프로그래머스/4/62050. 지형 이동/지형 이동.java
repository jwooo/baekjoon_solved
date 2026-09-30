import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int[][] land, int height) {
        int n = land.length;
        parent = new int[n * n];
        
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
        }
        
        List<int[]> edges = new ArrayList<>();
        int[] dr = {1, 0};
        int[] dc = {0, 1};
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int current = r * n + c;
                
                for (int d = 0; d < 2; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    if (nr >= n || nc >= n) continue;
                    
                    int next = nr * n + nc;
                    int cost = Math.abs(land[r][c] - land[nr][nc]);
                    
                    if (cost > height) {
                        edges.add(new int[]{cost, current, next});
                    } else {
                        union(current, next);
                    }
                }
            }
        }
        
        edges.sort(Comparator.comparingInt(a -> a[0]));
        
        int answer = 0;
        
        for (int[] edge : edges) {
            if (union(edge[1], edge[2])) {
                answer += edge[0];
            }
        }
        
        return answer;
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return false;
        
        parent[b] = a;
        return true;
    }
}