import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new ArrayDeque<>();
        
        for (int i = 0; i < cities.length; i++) {
            String now = cities[i].toLowerCase();
            
            boolean hasCache = false;
            while (!deque.isEmpty()) {
                String dequeNow = deque.poll();
                
                if (dequeNow.equals(now)) {
                    hasCache = true;
                } else queue.offer(dequeNow);
            }
            
            if (hasCache) {
                while (!queue.isEmpty()) {
                    deque.offer(queue.poll());
                }
                deque.offer(now);
                
                answer++;
            } else {
                if (queue.size() == cacheSize) queue.poll();
                
                while (!queue.isEmpty()) {
                    deque.offer(queue.poll());
                }
                
                if (cacheSize != 0) {
                	deque.offer(now);
                }
                
                answer += 5;
            }
        }
        
        return answer;
    }
}