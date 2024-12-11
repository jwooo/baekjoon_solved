import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxPriority = 0;
        boolean isFind = false;
        
        int[] prioritiesCount = new int[11];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            prioritiesCount[priorities[i]]++;
            queue.offer(new int[]{priorities[i], i});
         
            maxPriority = Math.max(maxPriority, priorities[i]);
        }
        
        while (!isFind) {
            int[] now = queue.poll();
            
            int nowValue = now[0];
            int nowIndex = now[1];
            
            // System.out.print("[NOWVALUE] = " + nowValue);
            // System.out.print(", [NOWINDEX] = " + nowIndex);
            // System.out.println(", [MAX] = " + maxPriority);
            
            if (maxPriority > nowValue) {
            	// System.out.println(" > [maxPriority > nowValue] = " + nowValue);
                queue.offer(new int[]{nowValue, nowIndex});
            } else {
                if (nowIndex == location) isFind = true;
                else {
                    prioritiesCount[nowValue]--;
                    
                    for (int i = nowValue; i > 0; i--) {
                        if (prioritiesCount[i] > 0) {
                            maxPriority = i;
                            break;
                        }
                    }
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}