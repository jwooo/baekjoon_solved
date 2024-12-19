import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            queue.offer(works[i]);
        }
        
        while (n-- > 0 && !queue.isEmpty()) {
            int now = queue.poll() - 1;
            
            if (now != 0) queue.offer(now);
        }
        
        if (queue.isEmpty()) return answer;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            answer += now * now;
        }
        
        return answer;
    }
}