import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] essences = parseToEssence(n, k).split("0");
        for (int i = 0; i < essences.length; i++) {
            String now = essences[i];
            
            if (now.equals("")) continue;
            if (isDecimal(now)) answer++;
        }
        
        return answer;
    }
    
    private String parseToEssence(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
    
    private boolean isDecimal(String str) {
        double number = Double.parseDouble(str);
        
        if (number == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
    
}