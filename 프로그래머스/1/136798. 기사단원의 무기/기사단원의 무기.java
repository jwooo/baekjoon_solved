import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        List<Integer> counts = new ArrayList<>();
        
        for (int i = 1; i <= number; i++) {
            counts.add(getMesureCount(i));
        }
        
        for (int count : counts) {
            if (count <= limit) {
                answer += count;
            } else {
                answer += power;
            }
        }
        
        return answer;
    }
    
    private int getMesureCount(int number) {
        int count = 0;
        
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        
        return count;
    }
}