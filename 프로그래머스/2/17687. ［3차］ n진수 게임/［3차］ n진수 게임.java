import java.util.*;

class Solution {
    
    private static Map<Integer, String> map;
    
    public String solution(int n, int t, int m, int p) {
        map = initMap();
        
        int nowIndex = 0;
        int nowNumber = 0;
        String[] numbers = new String[t * m];
        
        while (nowIndex < t * m) {
            String essence = convertToEssence(nowNumber, n);
            int size = essence.length();
            
            for (int i = 0; i < size; i++) {
                numbers[nowIndex++] = String.valueOf(essence.charAt(i));
                if (nowIndex == t * m) break;
            }
            
            nowNumber++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = p - 1; i < numbers.length; i = i + m) {
            sb.append(numbers[i]);
        }
        
        return sb.toString();
    }
    
    private Map<Integer, String> initMap() {
        Map<Integer, String> map = new HashMap<>();
        
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        
        return map;
    }
    
    private String convertToEssence(int number, int n) {
        StringBuilder sb = new StringBuilder();
        
        if (number == 0) return sb.append(0).toString();
        
        while (number > 0) {
            int value = number % n;
            
            if (value > 9) {
                sb.append(map.get(value));
            } else {
                sb.append(String.valueOf(value));
            }
            
            number = number / n;
        }
        
        return sb.reverse().toString();
    }
    
}