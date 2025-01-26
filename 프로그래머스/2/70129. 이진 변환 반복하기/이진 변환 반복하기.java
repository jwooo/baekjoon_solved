import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            answer[0]++;
            
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') length++;
                else answer[1]++;
            }
            
            StringBuilder sb = new StringBuilder();
            while (length > 0) {
                sb.append(length % 2);
                length /= 2;
            }
            
            s = sb.reverse().toString();
        }
        
        return answer;
    }
}