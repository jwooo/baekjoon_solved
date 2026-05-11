import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int firstWord = 0;
        int anotherWord = 0;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (sb.length() == 0) {
                firstWord++;
            } else if (sb.charAt(0) == c) {
                firstWord++;
            } else {
                anotherWord++;
            }
            
            sb.append(c);
            
            if (firstWord == anotherWord) {
                sb.setLength(0);
                firstWord = 0;
                anotherWord = 0;
                answer++;
            }
        }
        
        if (sb.length() != 0) answer++;
        return answer;
    }
}