import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
     
        for (int courseSize : course) {
            Map<String, Integer> map = new HashMap<>();
            
            for (String order : orders) {
                if (order.length() < courseSize) continue;
                
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);
                String sortedOrder = new String(charArr);
                
                generateCombination(sortedOrder, courseSize, 0, "", map);
            }
            
            int maxFrequency = 0;
            for (int frequency : map.values()) {
                if (frequency > maxFrequency) maxFrequency = frequency;
            }
            
			if (maxFrequency < 2) continue;
            
            for (String menu : map.keySet()) {
                if (map.get(menu) == maxFrequency) answer.add(menu);
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }
    
    private void generateCombination(String order, int r, int index, String current, Map<String, Integer> map) {
        if (current.length() == r) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = index; i < order.length(); i++) {
            generateCombination(order, r, i + 1, current + order.charAt(i), map);
        }
    }
    
}