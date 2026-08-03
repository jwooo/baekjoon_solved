import java.util.*;

class Solution {
    private long maxLeaves = 1;
    private long distLimit;
    private long splitLimit;
    private Map<Long, Long> minS = new HashMap<>();

    public int solution(int dist_limit, int split_limit) {
        this.distLimit = dist_limit;
        this.splitLimit = split_limit;
        this.maxLeaves = 1; 
        this.minS.clear();

        dfs(1L, 0L);

        return (int) maxLeaves;
    }

    private void dfs(long P, long S) {
        if (minS.containsKey(P) && minS.get(P) <= S) {
            return;
        }
        
        minS.put(P, S);

        for (int c = 2; c <= 3; c++) {
            long nextP = P * c;

            if (nextP <= splitLimit) {
                long availableDist = distLimit - S;
                long D = Math.min(P, Math.max(0L, availableDist));

                long leaves = P + D * (c - 1);
                maxLeaves = Math.max(maxLeaves, leaves);

                if (D == P) {
                    dfs(nextP, S + P);
                }
            }
        }
    }
}