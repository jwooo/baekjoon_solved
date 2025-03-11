import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        
        if (s.length() == 1) return 1;
        
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j += i) {
                String now = i+j < s.length() ? s.substring(j, j+i) : s.substring(j);
                String next = i+j < s.length() 
                    ? s.substring(j+i, Math.min(j+i*2, s.length()))
                    : "";
             
                if (now.equals(next)) {
                    map.put(now, map.getOrDefault(now, 1) + 1);
                } else {
                    if (map.containsKey(now)) {
                        sb.append(map.get(now)).append(now);
                        map.remove(now);
                    } else {
                        sb.append(now);
                    }
                }
            }
            
            answer = Math.min(answer, sb.length());
        }
        
        
        return answer;
    }
}