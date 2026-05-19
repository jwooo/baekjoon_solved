import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> pMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            pMap.put(participant[i], pMap.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            int count = pMap.get(completion[i]);
            
            if (count == 1) {
                pMap.remove(completion[i]);
            } else {
                pMap.put(completion[i], count - 1);
            }
        }
        
        return pMap.keySet().iterator().next();
    }
}