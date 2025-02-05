import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String[] now = clothes[i];
            map.put(now[1], map.getOrDefault(now[1], 1) + 1);
        }
        
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        
        return answer - 1;
    }
}