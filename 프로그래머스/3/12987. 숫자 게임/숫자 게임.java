import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < B.length; i++) {
            queue.offer(B[i]);
        }
        
        int index = 0;
        while (index < A.length && !queue.isEmpty()) {
            int now = A[index];
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                
                if (cur > now) {
                    index++;
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}