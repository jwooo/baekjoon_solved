import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int now = n % 3;
            
            if (now == 0) {
                answer.append("4");
                n--;
            } else {
                answer.append(now);
            }
            
            n = n / 3;
        }
        
        return answer.reverse().toString();
    }
}