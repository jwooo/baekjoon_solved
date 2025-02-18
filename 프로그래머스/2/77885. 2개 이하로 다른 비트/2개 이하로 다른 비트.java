import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            
            if (number % 2 == 0) answer[i] = number + 1;
            else {
                long bit = 1;
                long temp = number;
                
                while ((temp & 1) == 1) {
                    bit <<= 1;
                    temp >>= 1;
                }
                
                answer[i] = number + (bit >> 1);
            }
        }
        
        return answer;
    }
}