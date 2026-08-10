import java.util.*;

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long r1 = x;
        long r2 = x;
        long c1 = y;
        long c2 = y;
        
        long nl = (long) n;
        long ml = (long) m;
        
        for (int i = queries.length - 1; i >= 0; i--) {
            int cmd = queries[i][0];
            long dx = queries[i][1];
            
            if (cmd == 0) { 
                if (c1 > 0) c1 += dx;
                c2 += dx;
            } else if (cmd == 1) { 
                if (c2 < ml - 1) c2 -= dx;
                c1 -= dx;
            } else if (cmd == 2) { 
                if (r1 > 0) r1 += dx;
                r2 += dx;
            } else if (cmd == 3) { 
                if (r2 < nl - 1) r2 -= dx;
                r1 -= dx;
            }
            
            c1 = Math.max(0L, c1);
            c2 = Math.min(ml - 1, c2);
            r1 = Math.max(0L, r1);
            r2 = Math.min(nl - 1, r2);
            
            if (r1 > r2 || c1 > c2) return 0;
        }
        
        return (r2 - r1 + 1) * (c2 - c1 + 1);
    }
}