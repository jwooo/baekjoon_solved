import java.util.*;

class Solution {
    private char[][] grid;
    
    public String solution(int m, int n, String[] board) {
        grid = new char[m][n];
        Map<Character, int[][]> pos = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            grid[i] = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char ch = grid[i][j];
                if (ch >= 'A' && ch <= 'Z') {
                    if (!pos.containsKey(ch)) {
                        pos.put(ch, new int[2][2]);
                        pos.get(ch)[0] = new int[]{i, j};
                    } else {
                        pos.get(ch)[1] = new int[]{i, j};
                    }
                }
            }
        }
        
        List<Character> list = new ArrayList<>(pos.keySet());
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        
        while (!list.isEmpty()) {
            boolean removed = false;
            for (int i = 0; i < list.size(); i++) {
                char ch = list.get(i);
                int[][] p = pos.get(ch);
                int r1 = p[0][0], c1 = p[0][1];
                int r2 = p[1][0], c2 = p[1][1];
                
                if (canConnect(r1, c1, r2, c2)) {
                    grid[r1][c1] = '.';
                    grid[r2][c2] = '.';
                    sb.append(ch);
                    list.remove(i);
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                return "IMPOSSIBLE";
            }
        }
        
        return sb.toString();
    }
    
    private boolean canConnect(int r1, int c1, int r2, int c2) {
        if (r1 == r2) {
            return isRowClear(r1, c1, c2);
        }
        if (c1 == c2) {
            return isColClear(c1, r1, r2);
        }
        if (grid[r1][c2] == '.' && isRowClear(r1, c1, c2) && isColClear(c2, r1, r2)) {
            return true;
        }
        if (grid[r2][c1] == '.' && isColClear(c1, r1, r2) && isRowClear(r2, c1, c2)) {
            return true;
        }
        return false;
    }
    
    private boolean isRowClear(int r, int c1, int c2) {
        int min = Math.min(c1, c2);
        int max = Math.max(c1, c2);
        for (int c = min + 1; c < max; c++) {
            if (grid[r][c] != '.') return false;
        }
        return true;
    }
    
    private boolean isColClear(int c, int r1, int r2) {
        int min = Math.min(r1, r2);
        int max = Math.max(r1, r2);
        for (int r = min + 1; r < max; r++) {
            if (grid[r][c] != '.') return false;
        }
        return true;
    }
}