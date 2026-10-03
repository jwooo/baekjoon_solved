import java.util.*;

class Solution {
    private int minTotalWaitTime = Integer.MAX_VALUE;
    private int[][] waitTimes;
    private int K;

    public int solution(int k, int n, int[][] reqs) {
        this.K = k;
        
        @SuppressWarnings("unchecked")
        List<int[]>[] categoryReqs = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            categoryReqs[i] = new ArrayList<>();
        }
        
        for (int[] req : reqs) {
            categoryReqs[req[2]].add(req);
        }
        
        int maxCounselors = n - k + 1;
        waitTimes = new int[k + 1][maxCounselors + 1];
        
        for (int i = 1; i <= k; i++) {
            for (int m = 1; m <= maxCounselors; m++) {
                waitTimes[i][m] = calculateWaitTime(categoryReqs[i], m);
            }
        }
        
        dfs(1, n - k, 0);
        
        return minTotalWaitTime;
    }

    private int calculateWaitTime(List<int[]> reqList, int m) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int totalWait = 0;
        
        for (int[] req : reqList) {
            int a = req[0];
            int b = req[1];
            
            if (pq.size() < m) {
                pq.add(a + b);
            } else {
                int earliest = pq.poll();
                if (earliest <= a) {
                    pq.add(a + b);
                } else {
                    totalWait += earliest - a;
                    pq.add(earliest + b);
                }
            }
        }
        
        return totalWait;
    }

    private void dfs(int type, int remainExtra, int currentWait) {
        if (currentWait >= minTotalWaitTime) {
            return;
        }
        
        if (type == K) {
            currentWait += waitTimes[type][1 + remainExtra];
            minTotalWaitTime = Math.min(minTotalWaitTime, currentWait);
            return;
        }
        
        for (int extra = 0; extra <= remainExtra; extra++) {
            dfs(type + 1, remainExtra - extra, currentWait + waitTimes[type][1 + extra]);
        }
    }
}