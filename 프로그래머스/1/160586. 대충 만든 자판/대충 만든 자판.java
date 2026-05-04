import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> fastIndex = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            String now = keymap[i];
            
            for (int j = 0; j < now.length(); j++) {
                char c = now.charAt(j);
                
                if (!fastIndex.containsKey(c)) {
                    fastIndex.put(c, j);
                    continue;
                }
                
                int index = fastIndex.get(c);
                if (j < index) {
                    fastIndex.put(c, j);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            String now = targets[i];
            
            for (int j = 0; j < now.length(); j++) {
                char c = now.charAt(j);
                
                if (!fastIndex.containsKey(c)) {
                    count = -1;
                    break;
                }
                
                count += fastIndex.get(c) + 1;
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}