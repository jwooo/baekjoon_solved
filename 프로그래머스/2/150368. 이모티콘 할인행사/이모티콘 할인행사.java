import java.util.*;

class Solution {
    
    private static int[] discountRate = {10, 20, 30, 40};
    private static PriorityQueue<int[]> queue = new PriorityQueue<>((i, j) -> {
        if (i[0] != j[0]) return Integer.compare(j[0], i[0]);
        else return Integer.compare(j[1], i[1]);
    });
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, users, emoticons, new int[emoticons.length]);
        return queue.poll();
    }
    
    private void dfs(int depth, int[][] users, int[] emoticons, int[] discount) {
        if (depth == emoticons.length) {
            int count = 0;
            int cost = 0;
            
            for (int i = 0; i < users.length; i++) {
                int[] user = users[i];
                int spendCost = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (discount[j] >= user[0]) {
                        double ratio = discount[j];
                        double discountCost = emoticons[j] * (ratio / 100);
                        
                        spendCost += emoticons[j] - discountCost;
                    }
                }
                
                if (spendCost >= user[1]) count++;
                else cost += spendCost;
            }
            
            queue.offer(new int[] {count, cost});
            return;
        }
        
        for (int i = 0; i < discountRate.length; i++) {
            discount[depth] = discountRate[i];
            dfs(depth + 1, users, emoticons, discount);
        }
    }
}