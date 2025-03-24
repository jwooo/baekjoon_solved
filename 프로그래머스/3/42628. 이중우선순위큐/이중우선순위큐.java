import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((i, j) -> Integer.compare(j, i));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            
            if (operation[0].equals("I")) {
                int number = Integer.parseInt(operation[1]);
                
                maxQueue.offer(number);
                minQueue.offer(number);
            } else if (operation[1].equals("1")) {
                if (!maxQueue.isEmpty()) {
                    int now = maxQueue.poll();
                    minQueue.remove(now);
                }
            } else {
                if (!minQueue.isEmpty()) {
                    int now = minQueue.poll();
                    maxQueue.remove(now);
                }
            }
        }
        
        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        
        return answer;
    }
}