class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;

        int[][] max = new int[n][n];
        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i * 2]);

            max[i][i] = num;
            min[i][i] = num;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    String operator = arr[k * 2 + 1];

                    if (operator.equals("+")) {
                        max[i][j] = Math.max(
                                max[i][j],
                                max[i][k] + max[k + 1][j]
                        );

                        min[i][j] = Math.min(
                                min[i][j],
                                min[i][k] + min[k + 1][j]
                        );

                    } else {
                        max[i][j] = Math.max(
                                max[i][j],
                                max[i][k] - min[k + 1][j]
                        );

                        min[i][j] = Math.min(
                                min[i][j],
                                min[i][k] - max[k + 1][j]
                        );
                    }
                }
            }
        }

        return max[0][n - 1];
    }
}