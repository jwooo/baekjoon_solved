class Solution {

    int n, m;
    int[][] maze;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    boolean[][] redVisited;
    boolean[][] blueVisited;

    int redEndR, redEndC;
    int blueEndR, blueEndC;

    int answer = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;

        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];

        int redR = 0, redC = 0;
        int blueR = 0, blueC = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                if (maze[r][c] == 1) {
                    redR = r;
                    redC = c;
                } else if (maze[r][c] == 2) {
                    blueR = r;
                    blueC = c;
                } else if (maze[r][c] == 3) {
                    redEndR = r;
                    redEndC = c;
                } else if (maze[r][c] == 4) {
                    blueEndR = r;
                    blueEndC = c;
                }
            }
        }

        redVisited[redR][redC] = true;
        blueVisited[blueR][blueC] = true;

        dfs(redR, redC, blueR, blueC, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    void dfs(int rr, int rc, int br, int bc, int count) {

        if (count >= answer) {
            return;
        }

        if (rr == redEndR && rc == redEndC &&
            br == blueEndR && bc == blueEndC) {

            answer = Math.min(answer, count);
            return;
        }

        boolean redFinished =
                rr == redEndR && rc == redEndC;

        boolean blueFinished =
                br == blueEndR && bc == blueEndC;

        for (int rd = 0; rd < 4; rd++) {

            int nrr = rr;
            int nrc = rc;

            if (!redFinished) {
                nrr = rr + dr[rd];
                nrc = rc + dc[rd];

                if (!inRange(nrr, nrc)) {
                    continue;
                }

                if (maze[nrr][nrc] == 5) {
                    continue;
                }

                if (redVisited[nrr][nrc]) {
                    continue;
                }
            }

            for (int bd = 0; bd < 4; bd++) {

                int nbr = br;
                int nbc = bc;

                if (!blueFinished) {
                    nbr = br + dr[bd];
                    nbc = bc + dc[bd];

                    if (!inRange(nbr, nbc)) {
                        continue;
                    }

                    if (maze[nbr][nbc] == 5) {
                        continue;
                    }

                    if (blueVisited[nbr][nbc]) {
                        continue;
                    }
                }

                if (nrr == nbr && nrc == nbc) {
                    continue;
                }

                if (nrr == br && nrc == bc &&
                    nbr == rr && nbc == rc) {
                    continue;
                }

                if (!redFinished) {
                    redVisited[nrr][nrc] = true;
                }

                if (!blueFinished) {
                    blueVisited[nbr][nbc] = true;
                }

                dfs(nrr, nrc, nbr, nbc, count + 1);

                if (!redFinished) {
                    redVisited[nrr][nrc] = false;
                }

                if (!blueFinished) {
                    blueVisited[nbr][nbc] = false;
                }
            }
        }
    }

    boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}