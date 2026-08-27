class Solution {

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 4L * 100000000000000L;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canMove(mid, a, b, g, s, w, t)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canMove(
            long time,
            int a,
            int b,
            int[] g,
            int[] s,
            int[] w,
            int[] t
    ) {

        long gold = 0;
        long silver = 0;
        long total = 0;

        for (int i = 0; i < g.length; i++) {
            long count = time / (2L * t[i]);

            if (time % (2L * t[i]) >= t[i]) {
                count++;
            }

            long capacity = count * w[i];
            
            gold += Math.min((long) g[i], capacity);
            silver += Math.min((long) s[i], capacity);
            total += Math.min(
                    (long) g[i] + s[i],
                    capacity
            );

            if (gold >= a && silver >= b && total >= (long) a + b) {
                return true;
            }
        }

        return gold >= a
                && silver >= b
                && total >= (long) a + b;
    }
}
