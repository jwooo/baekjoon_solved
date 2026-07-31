import java.util.*;

class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] grid) {

        int R = grid.length;
        int C = grid[0].length();

        boolean[][][] visited = new boolean[R][C][4];
        List<Integer> answer = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {

                    if (visited[r][c][d]) continue;

                    int nr = r;
                    int nc = c;
                    int nd = d;
                    int len = 0;

                    while (!visited[nr][nc][nd]) {

                        visited[nr][nc][nd] = true;
                        len++;

                        char ch = grid[nr].charAt(nc);

                        if (ch == 'L') {
                            nd = (nd + 3) % 4;
                        } else if (ch == 'R') {
                            nd = (nd + 1) % 4;
                        }

                        nr = (nr + dr[nd] + R) % R;
                        nc = (nc + dc[nd] + C) % C;
                    }

                    answer.add(len);
                }
            }
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}