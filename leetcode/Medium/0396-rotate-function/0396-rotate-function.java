class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long current = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            current += (long) i * nums[i];
        }

        long max = current;

        for (int i = n - 1; i > 0; i--) {
            current = current + sum - (long) n * nums[i];
            max = Math.max(max, current);
        }

        return (int) max;
    }
}