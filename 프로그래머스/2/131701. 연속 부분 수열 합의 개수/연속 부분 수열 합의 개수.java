import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        for (int size = 1; size <= elements.length; size++) {
            for (int i = 0; i < elements.length; i++) {
                int result = 0;
                
                for (int j = i; j < i + size; j++) {
                    result += elements[j % elements.length];
                }
                
                answer.add(result);
            }
        }
        
        return answer.size();
    }
}