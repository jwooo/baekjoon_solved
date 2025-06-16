import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> requestPq = new PriorityQueue<>((i, j) -> {
           if (i[1] == j[1]) return Integer.compare(i[2], j[2]);
            return Integer.compare(i[1], j[1]);
        });
        
        PriorityQueue<int[]> workPq = new PriorityQueue<>((i, j) -> {
            if (i[2] != j[2]) return Integer.compare(i[2], j[2]);
            if (i[1] != j[1]) return Integer.compare(i[1], j[1]);
            return Integer.compare(i[0], j[0]);
        });
        
        for (int i = 0; i < jobs.length; i++) {
            int[] job = jobs[i];
            requestPq.offer(new int[] {i, job[0], job[1]});
        }
        
        int nowTime = requestPq.peek()[1];
        workPq.offer(requestPq.poll());
        
        while (!workPq.isEmpty()) {
            int[] nowWork = workPq.poll();
            
            nowTime += nowWork[2];
            answer += nowTime - nowWork[1];
            
            while (!requestPq.isEmpty() && requestPq.peek()[1] <= nowTime) {
                workPq.offer(requestPq.poll());
            }
            
            if (workPq.isEmpty() && !requestPq.isEmpty()) {
                int[] next = requestPq.poll();
                nowTime = next[1];
                workPq.offer(next);
            }
        }
        
        answer /= jobs.length;
        return answer;
    }
}