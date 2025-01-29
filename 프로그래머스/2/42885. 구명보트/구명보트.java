import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> queue = new LinkedList<>();
        
        Arrays.sort(people);
        
        for (int i = 0; i < people.length; i++) {
            queue.offer(people[i]);
        }
        
        while (queue.size() >= 2) {
            Integer min = queue.peek();
            Integer max = queue.peekLast();
            
            if (min + max <= limit) queue.poll();
            
            queue.pollLast();
            answer++;
        }
        
        answer += queue.size();
        
        return answer;
    }
}