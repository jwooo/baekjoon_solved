import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        if (set.size() < n) {
            answer = set.size();
        } else {
            answer = n;
        }
        
        return answer;
    }
}