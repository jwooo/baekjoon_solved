import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {

        List<Integer> seq = new ArrayList<>();
        seq.add(k);

        while (k != 1) {
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            seq.add(k);
        }

        int n = seq.size() - 1;

        double[] prefix = new double[n + 1];

        for (int i = 0; i < n; i++) {
            double area = (seq.get(i) + seq.get(i + 1)) / 2.0;
            prefix[i + 1] = prefix[i] + area;
        }

        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix[end] - prefix[start];
            }
        }

        return answer;
    }
}