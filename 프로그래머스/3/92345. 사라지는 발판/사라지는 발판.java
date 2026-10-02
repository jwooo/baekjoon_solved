class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Result {
        boolean win;
        int count;

        Result(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]).count;
    }

    private Result dfs(int[][] board, int curR, int curC, int opR, int opC) {
        if (board[curR][curC] == 0) {
            return new Result(false, 0);
        }

        boolean canWin = false;
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;

        board[curR][curC] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = curR + dr[i];
            int nc = curC + dc[i];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 1) {
                Result res = dfs(board, opR, opC, nr, nc);
                if (!res.win) {
                    canWin = true;
                    minWin = Math.min(minWin, res.count + 1);
                } else {
                    maxLose = Math.max(maxLose, res.count + 1);
                }
            }
        }

        board[curR][curC] = 1;

        if (canWin) {
            return new Result(true, minWin);
        } else {
            return new Result(false, maxLose);
        }
    }
}