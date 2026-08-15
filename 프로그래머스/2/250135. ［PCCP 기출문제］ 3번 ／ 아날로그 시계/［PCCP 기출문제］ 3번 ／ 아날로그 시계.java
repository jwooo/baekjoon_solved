class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        long minuteCount = countMinute(start, end);
        long hourCount = countHour(start, end);
        long overlap = countOverlap(start, end);

        return (int) (minuteCount + hourCount - overlap);
    }

    private long countMinute(int start, int end) {
        long minK = (start * 59L + 3599) / 3600;
        long maxK = (end * 59L) / 3600;

        return Math.max(0, maxK - minK + 1);
    }

    private long countHour(int start, int end) {
        long minK = (start * 719L + 43199) / 43200;
        long maxK = (end * 719L) / 43200;

        return Math.max(0, maxK - minK + 1);
    }

    private long countOverlap(int start, int end) {
        long count = 0;

        if (start <= 0 && 0 <= end) {
            count++;
        }

        if (start <= 43200 && 43200 <= end) {
            count++;
        }

        return count;
    }
}