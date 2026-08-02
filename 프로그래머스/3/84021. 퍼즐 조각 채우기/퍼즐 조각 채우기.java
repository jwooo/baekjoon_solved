import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;

        boolean[][] boardVisited = new boolean[n][n];
        boolean[][] tableVisited = new boolean[n][n];

        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> puzzles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!boardVisited[i][j] && game_board[i][j] == 0) {
                    blanks.add(bfs(game_board, boardVisited, i, j, 0));
                }

                if (!tableVisited[i][j] && table[i][j] == 1) {
                    puzzles.add(bfs(table, tableVisited, i, j, 1));
                }
            }
        }

        boolean[] used = new boolean[puzzles.size()];
        int answer = 0;

        for (List<int[]> blank : blanks) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (used[i]) continue;

                List<int[]> puzzle = puzzles.get(i);

                for (int r = 0; r < 4; r++) {
                    if (same(blank, puzzle)) {
                        answer += blank.size();
                        used[i] = true;
                        break;
                    }
                    puzzle = rotate(puzzle);
                }

                if (used[i]) break;
            }
        }

        return answer;
    }

    List<int[]> bfs(int[][] map, boolean[][] visited, int sx, int sy, int target) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> shape = new ArrayList<>();

        visited[sx][sy] = true;
        queue.offer(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            shape.add(new int[]{cur[0], cur[1]});

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != target) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }

        return normalize(shape);
    }

    List<int[]> normalize(List<int[]> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            result.add(new int[]{p[0] - minX, p[1] - minY});
        }

        result.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return result;
    }

    List<int[]> rotate(List<int[]> shape) {
        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            result.add(new int[]{p[1], -p[0]});
        }

        return normalize(result);
    }

    boolean same(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }

        return true;
    }
}