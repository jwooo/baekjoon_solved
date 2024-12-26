import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        char prevLastWord = words[0].charAt(words[0].length() - 1);
        Set<String> prevWords = new HashSet<>();
        
        prevWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String now = words[i];
            char nowFirstWord = now.charAt(0);
            
            if (prevWords.contains(now) || now.length() == 1 || prevLastWord != nowFirstWord) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            prevWords.add(now);
            prevLastWord = now.charAt(now.length() - 1);
        }

        return answer;
    }
}