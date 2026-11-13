class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int value = -101;

        int index = 0;
        while (index < nums.length) {
            if (nums[index] != value) {
                value = nums[index];
                nums[count]= value;
                count++;
            } 

            index++;
        }
        
        return count;
    }
}