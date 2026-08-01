class Solution {

    int maxDiff = -1;
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        return answer;
    }

    void dfs(int idx, int remain, int[] lion, int[] apeach) {
        if (idx == 11 || remain == 0) {

            int[] temp = lion.clone();

            if (remain > 0)
                temp[10] += remain;

            int lionScore = 0;
            int apeachScore = 0;

            for (int i = 0; i < 11; i++) {
                int score = 10 - i;

                if (temp[i] == 0 && apeach[i] == 0)
                    continue;

                if (temp[i] > apeach[i])
                    lionScore += score;
                else
                    apeachScore += score;
            }

            if (lionScore <= apeachScore)
                return;

            int diff = lionScore - apeachScore;

            if (diff > maxDiff) {
                maxDiff = diff;
                answer = temp;
            } else if (diff == maxDiff) {
                if (isBetter(temp, answer))
                    answer = temp;
            }
            return;
        }

        int need = apeach[idx] + 1;
        if (remain >= need) {
            lion[idx] = need;
            dfs(idx + 1, remain - need, lion, apeach);
            lion[idx] = 0;
        }

        dfs(idx + 1, remain, lion, apeach);
    }

    boolean isBetter(int[] a, int[] b) {
        for (int i = 10; i >= 0; i--) {
            if (a[i] != b[i])
                return a[i] > b[i];
        }
        return false;
    }
}