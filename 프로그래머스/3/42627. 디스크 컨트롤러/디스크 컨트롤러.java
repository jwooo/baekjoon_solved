import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> requestPq = new PriorityQueue<>((i, j) -> i[0] - j[0]);
        
        for (int[] job : jobs) {
            requestPq.offer(job);
        }
        
        PriorityQueue<int[]> workPq = new PriorityQueue<>((i, j) -> {
           	if (i[1] != j[1]) return i[1] - j[1];
            return i[0] - j[0];
        });
        
        int totalResponseTime = 0;
        int nowTime = 0;
        int completedJobs = 0;
        
        while (completedJobs < jobs.length) {
            while (!requestPq.isEmpty() && requestPq.peek()[0] <= nowTime) {
                workPq.offer(requestPq.poll());
            }
           	
            if (!workPq.isEmpty()) {
                int[] nowJob = workPq.poll();
                nowTime += nowJob[1];
                totalResponseTime += (nowTime - nowJob[0]);
                completedJobs++;
            } else {
                if (!requestPq.isEmpty()) nowTime = requestPq.peek()[0];
                else break;
            }
        }
        
        return totalResponseTime / jobs.length;
    }
}