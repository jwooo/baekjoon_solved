import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            String prev = "";
            boolean possible = true;
            
            while (!b.isEmpty()) {
                boolean matched = false;
                
                for (String word : words) {
                    if (!word.equals(prev) && b.startsWith(word)) {
                        prev = word;
                        b = b.substring(word.length());
                        matched = true;
                        break;
                    }
                }
                
                if (!matched) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                answer++;
            }
        }
        
        return answer;
    }
    
}