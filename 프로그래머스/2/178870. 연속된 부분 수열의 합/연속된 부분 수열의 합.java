import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        
        int start = 0;
        int end = -1;
        int sum = 0;
        int length = 1_000_001;
        
        while (end < sequence.length) {
            if (sum < k) {
                if (++end < sequence.length) sum += sequence[end];
            } else if (k < sum) {
                sum -= sequence[start++];
            } else {
                if (end - start < length) {
                    length = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                
                sum -= sequence[start++];
            }
        }
        
        return answer;
    }
}