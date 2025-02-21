import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;
        if (total % 2 != 0) return -1;
        
        long target = total / 2;
        int count = 0;
        int maxOperations = queue1.length * 4;
        
        while (count <= maxOperations) {
            if (sum1 == target) return count;
            if (sum1 > target) {
                int x = q1.poll();
                sum1 -= x;
                sum2 += x;
                q2.offer(x);
            } else {
                int x = q2.poll();
                sum1 += x;
                sum2 -= x;
                q1.offer(x);
            }
            
            count++;
        }
       
        return -1;
    }
}