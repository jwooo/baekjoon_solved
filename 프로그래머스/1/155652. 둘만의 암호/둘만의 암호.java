import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answerBuilder = new StringBuilder();
        
        for (int i= 0; i < s.length(); i++) {
            int skipCount = 0;
            char now = s.charAt(i);
         
            while (skipCount < index) {
                now = (char) ((now + 1));
                
                if (now > 'z') now = 'a';
                if (!containsWord(skip, now)) skipCount++;
            }
         
            answerBuilder.append(now);
        }
     
        return answerBuilder.toString();
    }
    
    private boolean containsWord(String skip, char word) {
        for (int i = 0; i < skip.length(); i++) {
            if (word == skip.charAt(i)) return true;
        }
        
        return false;
    }
}