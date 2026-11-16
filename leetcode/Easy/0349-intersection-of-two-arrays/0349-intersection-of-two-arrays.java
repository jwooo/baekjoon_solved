class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.remove(num)) {
                result.add(num);
            }
        }

        return result.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}