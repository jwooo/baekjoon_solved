import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        int aggSize1 = aggregateToMap(str1, map1);
        int aggSize2 = aggregateToMap(str2, map2);
        
        if (aggSize1 == 0 && aggSize2 == 0) return 65536;
        
        double interAggSize = 0;
        double unionAggSize = (double) (aggSize1 + aggSize2);
        
        for (String key: map1.keySet()) {
            if (map2.containsKey(key)) {
                Integer inter1 = map1.get(key);
                Integer inter2 = map2.get(key);
                
                interAggSize += Math.min(inter1, inter2);
            }
        }
        
        unionAggSize -= interAggSize;
        double jacard = interAggSize / unionAggSize * 65536;
        answer = (int) Math.floor(jacard);
        
        return answer;
    }
    
    private int aggregateToMap(String str, Map<String, Integer> map) {
        String lowerStr = str.toLowerCase();
        
        int aggregateSize = 0;
        
        for (int i = 0; i < lowerStr.length() - 1; i++) {
            char word1 = lowerStr.charAt(i);
            char word2 = lowerStr.charAt(i + 1);
            
            if (isEnglish(word1) && isEnglish(word2)) {
                String word = String.valueOf(new char[]{word1, word2});
                
                map.put(word, map.getOrDefault(word, 0) + 1);
                aggregateSize++;
            }
        }
        
        return aggregateSize;
    }
    
    private boolean isEnglish(char c) {
        return (c >= 'a') && (c <= 'z');
    }
    
}