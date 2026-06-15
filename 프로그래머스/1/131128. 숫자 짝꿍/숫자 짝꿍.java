import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < Y.length(); i++) {
            char now = Y.charAt(i);
            map.put(now, map.getOrDefault(now, 0) + 1);
        }
        
        for (int i = 0; i < X.length(); i++) {
            char now = X.charAt(i);
            
            if (!map.containsKey(now)) {
                continue;
            }
         
            int count = map.get(now);
            
            if (count == 1) {
                map.remove(now);
            } else {
                map.put(now, count - 1);
            }
            
            result.add(now - '0');
        }
        
        if (result.isEmpty()) {
            return "-1";
        }
        
        Collections.sort(result, Collections.reverseOrder());
        
        boolean isAllZero = true;
        for (Integer now : result) {
            if (now != 0) {
                isAllZero = false;
            }
            
            sb.append(now);
        }
        
        if (isAllZero) {
            return "0";
        }
        
        return sb.toString();
    }
}