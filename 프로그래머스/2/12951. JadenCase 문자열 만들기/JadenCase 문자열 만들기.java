import java.util.*;

class Solution {
    public String solution(String s) {
        int nowIndex = 0;
        StringTokenizer st = new StringTokenizer(s);
        
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String now = st.nextToken().toLowerCase();
            
            char first = now.charAt(0);
            
            if (first >= '0' && first <= '9') {
                sb.append(now);
                nowIndex += now.length();
            } else {
                
                sb.append(String.valueOf(first).toUpperCase());
                for (int i = 1; i < now.length(); i++) {
                    sb.append(now.charAt(i));
                }
                
                nowIndex += now.length();
            }
            
            for (int i = nowIndex; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append(" ");
                    nowIndex++;
                } else break;
            }
            
        }
        
        return sb.toString();
    }
}