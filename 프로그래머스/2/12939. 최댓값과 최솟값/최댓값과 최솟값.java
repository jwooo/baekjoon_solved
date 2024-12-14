import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            
            max = Math.max(max, now);
            min = Math.min(min, now);
        }
        
        answer.append(min).append(" ").append(max);
        
        return answer.toString();
    }
}