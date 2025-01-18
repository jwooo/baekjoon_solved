import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int now : scoville) {
            queue.offer(now);
        }
        
        int min = queue.peek();
        while (min < K) {
            if (queue.size() >= 2) {
                queue.offer(queue.poll() + queue.poll() * 2);
                min = queue.peek();
                answer++;
            } else {
                return -1;
            }
        }
        
        return answer;
    }
}