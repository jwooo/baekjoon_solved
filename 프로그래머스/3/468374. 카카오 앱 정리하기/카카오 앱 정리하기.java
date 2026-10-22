import java.util.*;

class Solution {
    int n, m;
    int[][] board;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int[][] solution(int[][] board, int[][] commands) {
        n = board.length;
        m = board[0].length;
        this.board = new int[n][m];

        for (int i = 0; i < n; i++) {
            this.board[i] = board[i].clone();
        }

        for (int[] command : commands) {
            moveCommand(command[0], command[1] - 1);
        }

        return this.board;
    }

    private void moveCommand(int id, int dir) {
        boolean[] moving = getMovingApps(id, dir);
        moveApps(moving, dir);

        while (true) {
            int splitApp = findSplitApp(dir);

            if (splitApp == 0) {
                break;
            }

            moving = getMovingApps(splitApp, dir);
            moveApps(moving, dir);
        }
    }

    private boolean[] getMovingApps(int start, int dir) {
        boolean[] moving = new boolean[101];
        Queue<Integer> queue = new ArrayDeque<>();

        moving[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (board[r][c] != current) {
                        continue;
                    }

                    int nr = (r + dr[dir] + n) % n;
                    int nc = (c + dc[dir] + m) % m;
                    int next = board[nr][nc];

                    if (next != 0 && !moving[next]) {
                        moving[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return moving;
    }

    private void moveApps(boolean[] moving, int dir) {
        int[][] nextBoard = new int[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int id = board[r][c];

                if (id == 0) {
                    continue;
                }

                if (moving[id]) {
                    int nr = (r + dr[dir] + n) % n;
                    int nc = (c + dc[dir] + m) % m;
                    nextBoard[nr][nc] = id;
                } else {
                    nextBoard[r][c] = id;
                }
            }
        }

        board = nextBoard;
    }

    private int findSplitApp(int dir) {
        boolean[] checked = new boolean[101];

        if (dir == 0 || dir == 2) {
            for (int r = 0; r < n; r++) {
                int id = board[r][0];

                if (id == 0 || id != board[r][m - 1] || checked[id]) {
                    continue;
                }

                for (int c = 1; c < m - 1; c++) {
                    if (board[r][c] != id) {
                        checked[id] = true;
                        return id;
                    }
                }
            }
        } else {
            for (int c = 0; c < m; c++) {
                int id = board[0][c];

                if (id == 0 || id != board[n - 1][c] || checked[id]) {
                    continue;
                }

                for (int r = 1; r < n - 1; r++) {
                    if (board[r][c] != id) {
                        checked[id] = true;
                        return id;
                    }
                }
            }
        }

        return 0;
    }
}