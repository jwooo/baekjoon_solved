import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] count = new int[10_000_001];
        
        for (int i = 0; i < tangerine.length; i++) {
            count[tangerine[i]]++;
        }
        
        Arrays.sort(count);
        
        for (int i = count.length - 1; i >= 0; i--) {
            int now = k - count[i];
            
            if (now <= 0) {
                answer++;
                break;
            }
            
            k = now;
            answer++;
        }
        
        return answer;
    }
}