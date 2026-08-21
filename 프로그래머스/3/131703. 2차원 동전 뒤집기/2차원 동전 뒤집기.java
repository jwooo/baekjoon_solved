class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;

        int answer = Integer.MAX_VALUE;

        answer = Math.min(answer, solve(beginning, target, false));
        answer = Math.min(answer, solve(beginning, target, true));

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int solve(int[][] beginning, int[][] target, boolean firstRowFlip) {
        int n = beginning.length;
        int m = beginning[0].length;

        boolean[] rowFlip = new boolean[n];
        boolean[] colFlip = new boolean[m];

        rowFlip[0] = firstRowFlip;

        int count = firstRowFlip ? 1 : 0;

        for (int j = 0; j < m; j++) {
            int value = beginning[0][j];

            if (firstRowFlip) {
                value ^= 1;
            }

            if (value != target[0][j]) {
                colFlip[j] = true;
                count++;
            }
        }

        for (int i = 1; i < n; i++) {

            boolean needRowFlip = false;
            int value = beginning[i][0];

            if (colFlip[0]) {
                value ^= 1;
            }

            if (value != target[i][0]) {
                needRowFlip = true;
            }

            rowFlip[i] = needRowFlip;

            if (needRowFlip) {
                count++;
            }

            for (int j = 0; j < m; j++) {
                value = beginning[i][j];

                if (needRowFlip) {
                    value ^= 1;
                }

                if (colFlip[j]) {
                    value ^= 1;
                }

                if (value != target[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return count;
    }
}