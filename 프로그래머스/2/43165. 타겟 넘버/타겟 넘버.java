import java.util.*;

class Solution {
    
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        
        return answer;
    }
    
    private void dfs(int now, int index, int target, int[] numbers) {
        if (index == numbers.length) {
            if (target == now) answer++;
            return;
        }
        
        dfs(now + numbers[index] * 1, index + 1, target, numbers);
        dfs(now + numbers[index] * -1, index + 1, target, numbers);
    }
}