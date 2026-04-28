import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        List<List<Integer>> combs = new ArrayList<>();
        combination(nums, 0, new ArrayList<>(), combs);
        
        for (List<Integer> comb : combs) {
            boolean valid = true;
            
            for (int i = 0; i < q.length; i++) {
                int count = 0;
                
                for (int num : q[i]) {
                    if (comb.contains(num)) count++;
                }
                
                if (count != ans[i]) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) answer++;
        }
        
        return answer;
    }
    
    private void combination(List<Integer> nums, int start, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == 5) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < nums.size(); i++) {
            temp.add(nums.get(i));
            combination(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}