import java.util.*;

class Solution {
    static class Node {
        int r1, c1, r2, c2, cost;
        public Node(int r1, int c1, int r2, int c2, int cost) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][n][2]; 

        q.offer(new Node(0, 0, 0, 1, 0));
        visited[0][0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if ((curr.r1 == n - 1 && curr.c1 == n - 1) || (curr.r2 == n - 1 && curr.c2 == n - 1)) {
                return curr.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nr1 = curr.r1 + dr[i];
                int nc1 = curr.c1 + dc[i];
                int nr2 = curr.r2 + dr[i];
                int nc2 = curr.c2 + dc[i];

                if (isValid(nr1, nc1, nr2, nc2, n, board)) {
                    int dir = (nr1 == nr2) ? 0 : 1;
                    int minR = Math.min(nr1, nr2);
                    int minC = Math.min(nc1, nc2);
                    if (!visited[minR][minC][dir]) {
                        visited[minR][minC][dir] = true;
                        q.offer(new Node(nr1, nc1, nr2, nc2, curr.cost + 1));
                    }
                }
            }

            if (curr.r1 == curr.r2) { 
                int r = curr.r1;
                for (int d = -1; d <= 1; d += 2) {
                    if (r + d >= 0 && r + d < n && board[r + d][curr.c1] == 0 && board[r + d][curr.c2] == 0) {
                        int minR = Math.min(r, r + d);
                        if (!visited[minR][curr.c1][1]) {
                            visited[minR][curr.c1][1] = true;
                            q.offer(new Node(r, curr.c1, r + d, curr.c1, curr.cost + 1));
                        }
                        
                        if (!visited[minR][curr.c2][1]) {
                            visited[minR][curr.c2][1] = true;
                            q.offer(new Node(r, curr.c2, r + d, curr.c2, curr.cost + 1));
                        }
                    }
                }
            } else { 
                int c = curr.c1;
                for (int d = -1; d <= 1; d += 2) {
                    if (c + d >= 0 && c + d < n && board[curr.r1][c + d] == 0 && board[curr.r2][c + d] == 0) {
                        int minC = Math.min(c, c + d);
                        if (!visited[curr.r1][minC][0]) {
                            visited[curr.r1][minC][0] = true;
                            q.offer(new Node(curr.r1, c, curr.r1, c + d, curr.cost + 1));
                        }
                        
                        if (!visited[curr.r2][minC][0]) {
                            visited[curr.r2][minC][0] = true;
                            q.offer(new Node(curr.r2, c, curr.r2, c + d, curr.cost + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean isValid(int r1, int c1, int r2, int c2, int n, int[][] board) {
        if (r1 < 0 || r1 >= n || c1 < 0 || c1 >= n || r2 < 0 || r2 >= n || c2 < 0 || c2 >= n) return false;
        if (board[r1][c1] == 1 || board[r2][c2] == 1) return false;
        return true;
    }
}