import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int n = number.length() - k;
        StringBuilder answer = new StringBuilder();
        
        int toRemove = k;
        for (char c : number.toCharArray()) {
            while (toRemove > 0 && answer.length() > 0 && answer.charAt(answer.length() - 1) < c) {
                answer.deleteCharAt(answer.length() - 1);
                toRemove--;
            }
            
            answer.append(c);
        }
     
        return answer.substring(0, n);
    }
}