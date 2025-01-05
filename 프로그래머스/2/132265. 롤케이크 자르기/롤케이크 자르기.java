import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> dish1 = new HashMap<>();
        Map<Integer, Integer> dish2 = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            dish2.put(topping[i], dish2.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            Integer now = topping[i];
            
            dish1.put(now, dish1.getOrDefault(now, 0) + 1);
            
            if (dish2.containsKey(now)) {
                if (dish2.get(now) == 1) dish2.remove(now);
                else dish2.put(now, dish2.getOrDefault(now, 0) - 1);
            }
            
            if (dish1.keySet().size() == dish2.keySet().size()) answer++;
        }
        
        return answer;
    }
}