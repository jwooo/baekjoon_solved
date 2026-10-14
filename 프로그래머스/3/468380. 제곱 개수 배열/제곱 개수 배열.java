import java.util.*;

class Solution {
    public long[] solution(int[] arr, long l, long r) {
        int n = arr.length;
        long[] ends = new long[n];
        long[] squarePrefix = new long[n];
        long total = 0;
        long squares = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
            ends[i] = total;
            squares += (long) arr[i] * arr[i];
            squarePrefix[i] = squares;
        }

        long length = r - l + 1;
        long k = prefixSum(r, arr, ends, squarePrefix)
                - prefixSum(l - 1, arr, ends, squarePrefix);

        if (length == total) {
            return new long[]{k, 1};
        }

        long maxStart = total - length;
        List<Long> points = new ArrayList<>();
        points.add(0L);
        points.add(maxStart);

        for (int i = 0; i < n - 1; i++) {
            long boundary = ends[i];
            long shifted = boundary - length;

            if (boundary > 0 && boundary < maxStart) {
                points.add(boundary);
            }

            if (shifted > 0 && shifted < maxStart) {
                points.add(shifted);
            }
        }

        Collections.sort(points);

        long count = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            long a = points.get(i);
            long next = points.get(i + 1);

            if (a >= next) {
                continue;
            }

            long b = next - 1;
            long firstSum = prefixSum(a + length, arr, ends, squarePrefix)
                    - prefixSum(a, arr, ends, squarePrefix);

            long diff = valueAt(a + length, arr, ends)
                    - valueAt(a, arr, ends);

            if (diff == 0) {
                if (firstSum == k) {
                    count += b - a + 1;
                }
            } else {
                long delta = k - firstSum;

                if (delta % diff == 0) {
                    long offset = delta / diff;

                    if (offset >= 0 && offset <= b - a) {
                        count++;
                    }
                }
            }
        }

        long finalSum = prefixSum(maxStart + length, arr, ends, squarePrefix)
                - prefixSum(maxStart, arr, ends, squarePrefix);

        if (finalSum == k) {
            count++;
        }

        return new long[]{k, count};
    }

    private long prefixSum(long x, int[] arr, long[] ends, long[] squarePrefix) {
        if (x == 0) {
            return 0;
        }

        int low = 0;
        int high = ends.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (ends[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long prevEnd = low == 0 ? 0 : ends[low - 1];
        long prevSum = low == 0 ? 0 : squarePrefix[low - 1];

        return prevSum + (x - prevEnd) * arr[low];
    }

    private int valueAt(long index, int[] arr, long[] ends) {
        int low = 0;
        int high = ends.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (ends[mid] <= index) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }
}