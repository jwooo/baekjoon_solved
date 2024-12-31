import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        boolean isDone = false;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while (!isDone) {
            answer++;
            List<Integer> winners = new ArrayList<>();
            
            while (!queue.isEmpty()) {
                Integer userA = queue.poll();
                Integer userB = queue.poll();
                
                if ((userA == a || userA == b) && (userB == a || userB == b)) {
                    return answer;
                } else if (userA == a || userA == b) {
                    winners.add(userA);
                } else if (userB == a || userB == b) {
                    winners.add(userB);
                } else {
                    winners.add(userA);
                }
            }
            
            winners.forEach(i -> queue.offer(i));
        }

        return answer;
    }
}