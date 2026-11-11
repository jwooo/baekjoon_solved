class Solution {
    public int strStr(String haystack, String needle) {
        int size = needle.length();

        for (int i = 0; i <= haystack.length() - size; i++) {
            String sub = haystack.substring(i, i + size);

            if (sub.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}