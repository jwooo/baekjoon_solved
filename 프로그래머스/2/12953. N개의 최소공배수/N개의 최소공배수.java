import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int value = 1;
            int now = arr[i];
            int answerNow = answer;
            boolean hasMultiple = true;
            
            while (hasMultiple) {
                hasMultiple = false;
                
                for (int j = 2; j <= Math.min(now, answerNow); j++) {
                    if (now % j == 0 && answerNow % j == 0) {
                        hasMultiple = true;
                        value *= j;
                        now = now / j;
                        answerNow = answerNow / j;
                        break;
                    }
                }
            }
 
            answer = value * now * answerNow;
        }
        
        return answer;
    }
}