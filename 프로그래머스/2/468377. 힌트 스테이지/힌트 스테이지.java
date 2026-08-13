class Solution {

    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int answer = Integer.MAX_VALUE;

        int total = 1 << (n - 1);

        for (int mask = 0; mask < total; mask++) {

            int sum = 0;
            int[] count = new int[n];

            for (int stage = 0; stage < n; stage++) {
                int use = count[stage];

                sum += cost[stage][use];

                if (stage == n - 1) {
                    continue;
                }

                if ((mask & (1 << stage)) != 0) {
                    sum += hint[stage][0];

                    for (int j = 1; j < hint[stage].length; j++) {
                        int targetStage = hint[stage][j] - 1;

                        if (count[targetStage] < n - 1) {
                            count[targetStage]++;
                        }
                    }
                }
            }

            answer = Math.min(answer, sum);
        }

        return answer;
    }
}