import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] board;
    boolean[] used = new boolean[7];
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int[][] board, int r, int c) {
        this.board = board;

        int count = 0;
        for (int[] row : board) {
            for (int value : row) {
                if (value != 0) {
                    count++;
                }
            }
        }

        dfs(r, c, count, 0);
        return answer;
    }

    void dfs(int r, int c, int remain, int cost) {
        if (remain == 0) {
            answer = Math.min(answer, cost);
            return;
        }

        if (cost >= answer) {
            return;
        }

        for (int card = 1; card <= 6; card++) {
            if (used[card]) {
                continue;
            }

            List<int[]> positions = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] == card) {
                        positions.add(new int[]{i, j});
                    }
                }
            }

            if (positions.size() != 2) {
                continue;
            }

            used[card] = true;

            int[] first = positions.get(0);
            int[] second = positions.get(1);

            int dist1 = move(r, c, first[0], first[1]);
            int dist2 = move(first[0], first[1], second[0], second[1]);

            board[first[0]][first[1]] = 0;
            board[second[0]][second[1]] = 0;

            dfs(second[0], second[1], remain - 2, cost + dist1 + dist2 + 2);

            board[first[0]][first[1]] = card;
            board[second[0]][second[1]] = card;

            int dist3 = move(r, c, second[0], second[1]);
            int dist4 = move(second[0], second[1], first[0], first[1]);

            board[first[0]][first[1]] = 0;
            board[second[0]][second[1]] = 0;

            dfs(first[0], first[1], remain - 2, cost + dist3 + dist4 + 2);

            board[first[0]][first[1]] = card;
            board[second[0]][second[1]] = card;

            used[card] = false;
        }
    }

    int move(int sr, int sc, int tr, int tc) {
        int[][] dist = new int[4][4];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == tr && c == tc) {
                return dist[r][c];
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }

                int[] next = ctrlMove(r, c, d);

                if (dist[next[0]][next[1]] == -1) {
                    dist[next[0]][next[1]] = dist[r][c] + 1;
                    queue.offer(next);
                }
            }
        }

        return 0;
    }

    int[] ctrlMove(int r, int c, int d) {
        int nr = r;
        int nc = c;

        while (true) {
            int tr = nr + dr[d];
            int tc = nc + dc[d];

            if (tr < 0 || tr >= 4 || tc < 0 || tc >= 4) {
                break;
            }

            nr = tr;
            nc = tc;

            if (board[nr][nc] != 0) {
                break;
            }
        }

        return new int[]{nr, nc};
    }
}