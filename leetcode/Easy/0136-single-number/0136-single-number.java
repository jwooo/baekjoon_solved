import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        int answer = set.stream().findFirst().orElse(-1);
        return answer;
    }
}