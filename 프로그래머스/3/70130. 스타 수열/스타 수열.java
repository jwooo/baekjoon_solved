class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] count = new int[n];

        for (int num : a) {
            count[num]++;
        }

        int max = 0;

        for (int x = 0; x < n; x++) {
            if (count[x] <= max) {
                continue;
            }

            int pairCount = 0;

            for (int i = 0; i < n - 1; i++) {
                if (a[i] == a[i + 1]) {
                    continue;
                }

                if (a[i] != x && a[i + 1] != x) {
                    continue;
                }
                
                pairCount++;
                i++;
            }

            max = Math.max(max, pairCount);
        }

        return max * 2;
    }
}