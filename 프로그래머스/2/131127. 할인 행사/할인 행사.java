import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wants = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> sales = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                String now = discount[j];
                
                if (!sales.containsKey(now)) sales.put(now, 1);
                else {
                    Integer nowValue = sales.get(now);
                    sales.put(now, ++nowValue);
                }
            }
            
            boolean isAllWant = true;
            for (String item : sales.keySet()) {
                Integer itemValue = sales.get(item);
                
                if (!wants.containsKey(item) || wants.get(item) != itemValue) {
                    isAllWant = false;
                    break;
                }
            }
            
            if (isAllWant) answer++;
        }
        
        return answer;
    }
}