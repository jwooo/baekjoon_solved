class Solution {
    public String mergeAlternately(String word1, String word2) {
        int nowIndex = 0;
        int word1MaxIndex = word1.length() - 1;
        int word2MaxIndex = word2.length() - 1;

        int maxIndex = Math.max(word1MaxIndex, word2MaxIndex);

        StringBuilder sb = new StringBuilder();
        while (nowIndex <= maxIndex) {
            if (nowIndex <= word1MaxIndex) {
                sb.append(word1.charAt(nowIndex));
            }
            if (nowIndex <= word2MaxIndex) {
                sb.append(word2.charAt(nowIndex));
            }

            nowIndex++;
        }

        return sb.toString();
    }
}