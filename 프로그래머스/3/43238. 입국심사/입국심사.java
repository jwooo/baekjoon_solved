import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        
        while (start < end) {
            long mid = (start + end) / 2;
            long count = 0;
            
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
                if (count > n) break;
            }
            
            if (count < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}