class Solution {
    private int answer;

    public int solution(int n) {
        answer = 0;
        dfs(n, 0, 0);
        return answer;
    }

    private void dfs(int n, int star, int plus) {
        if (n == 1) {
            if (plus == star * 2) {
                answer++;
            }
            return;
        }

        if (star > 19 || plus > 38 || plus < star * 2) {
            return;
        }

        if (plus < 38) {
            dfs(n - 1, star, plus + 1);
        }

        if (n % 3 == 0 && star < 19 && plus >= (star + 1) * 2) {
            dfs(n / 3, star + 1, plus);
        }
    }
}