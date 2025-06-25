import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int start = 1;
        int end = 200_000_000;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (isCrossBridge(mid, k, stones)) {
                answer = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean isCrossBridge(int human, int range, int[] stones) {
        int zeroCount = 0;
        
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i] - human;
            
            if (stone <= 0) {
                zeroCount++;
            } else {
                zeroCount = 0;
            }
            
            if (zeroCount >= range) {
                return false;
            }
        }
        
        return true;
    }
}