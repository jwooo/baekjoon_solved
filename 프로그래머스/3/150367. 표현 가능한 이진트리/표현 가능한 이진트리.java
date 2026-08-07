class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int len = binary.length();
            int treeSize = 1;

            while (treeSize < len) {
                treeSize = treeSize * 2 + 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < treeSize - len; j++) {
                sb.append('0');
            }

            sb.append(binary);
            answer[i] = check(sb.toString()) ? 1 : 0;
        }

        return answer;
    }

    private boolean check(String s) {
        if (s.length() == 1) return true;

        int mid = s.length() / 2;

        char root = s.charAt(mid);

        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);

        if (root == '0') {
            if (left.contains("1") || right.contains("1"))
                return false;
        }

        return check(left) && check(right);
    }
}