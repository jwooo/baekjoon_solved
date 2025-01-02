import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] times = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = extractTime(book_time[i][0]);
            times[i][1] = extractTime(book_time[i][1]) + 10;
        }
        
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for (int i = 0; i < times.length; i++) {
            while (!queue.isEmpty() && queue.peek()[1] <= times[i][0]) {
                queue.poll();
            }
            
            queue.offer(times[i]);
            answer = Math.max(answer, queue.size());
        }
        
        return answer;
    }
    
    private int extractTime(String time) {
        String[] times = time.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }
    
}