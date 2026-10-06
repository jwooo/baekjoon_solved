class Solution {
    public int solution(int[][] clockHands) {
        int n = clockHands.length;
        int answer = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << (2 * n)); mask++) {
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                board[i] = clockHands[i].clone();
            }

            int count = 0;
            int temp = mask;

            for (int c = 0; c < n; c++) {
                int turn = temp & 3;
                temp >>= 2;

                if (turn > 0) {
                    press(board, 0, c, turn);
                    count += turn;
                }
            }

            for (int r = 1; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int turn = (4 - board[r - 1][c]) % 4;

                    if (turn > 0) {
                        press(board, r, c, turn);
                        count += turn;
                    }
                }
            }

            boolean valid = true;

            for (int c = 0; c < n; c++) {
                if (board[n - 1][c] != 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer = Math.min(answer, count);
            }
        }

        return answer;
    }

    private void press(int[][] board, int r, int c, int count) {
        int n = board.length;
        int[] dr = {0, 1, -1, 0, 0};
        int[] dc = {0, 0, 0, 1, -1};

        for (int k = 0; k < 5; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                board[nr][nc] = (board[nr][nc] + count) % 4;
            }
        }
    }
}