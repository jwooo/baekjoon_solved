import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int now = order[answer];
         
            if (queue.peek() == now) {
                queue.poll();
                answer++;
            } else if (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
                answer++;
            } else {
                stack.push(queue.poll());
            }
        }
        
        while (!stack.isEmpty()) {
            int now = order[answer];
            
            if (stack.peek() == now) {
                stack.pop();
                answer++;
            } else break;
        }
        
        return answer;
    }
}