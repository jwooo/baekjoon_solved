class Solution {
    public long solution(int[][] land, int P, int Q) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] row : land) {
            for (int height : row) {
                min = Math.min(min, height);
                max = Math.max(max, height);
            }
        }

        long answer = Long.MAX_VALUE;

        while (min <= max) {
            int mid1 = min + (max - min) / 3;
            int mid2 = max - (max - min) / 3;

            long cost1 = getCost(land, mid1, P, Q);
            long cost2 = getCost(land, mid2, P, Q);

            answer = Math.min(answer, Math.min(cost1, cost2));

            if (cost1 <= cost2) {
                max = mid2 - 1;
            } else {
                min = mid1 + 1;
            }
        }

        return answer;
    }

    private long getCost(int[][] land, int target, int P, int Q) {
        long cost = 0;

        for (int[] row : land) {
            for (int height : row) {
                if (height < target) {
                    cost += (long) (target - height) * P;
                } else if (height > target) {
                    cost += (long) (height - target) * Q;
                }
            }
        }

        return cost;
    }
}