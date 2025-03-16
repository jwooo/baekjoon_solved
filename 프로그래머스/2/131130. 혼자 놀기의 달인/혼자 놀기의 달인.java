import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>((i, j) -> Integer.compare(j, i));
        
        for (int i = 0; i < cards.length; i++) {
            int nowIndex = i;
            
            int count = 0;
            while (!visited[nowIndex]) {
                visited[nowIndex] = true;
                nowIndex = cards[nowIndex] - 1;
                count++;
            }
            
            if (count != 0) queue.offer(count);
        }
        
        if (queue.size() == 1) return 0;
        answer = queue.poll() * queue.poll();
        
        return answer;
    }
}