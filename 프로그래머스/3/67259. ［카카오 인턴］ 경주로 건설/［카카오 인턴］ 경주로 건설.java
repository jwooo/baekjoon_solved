import java.util.*;

class Solution {

    static int[] dy = {1, 0, -1, 0}; 
    static int[] dx = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int N = board.length; 
        int[][][] minCost = new int[N][N][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(minCost[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();

        if (board[1][0] != 1) { 
            minCost[1][0][0] = 100; 
            pq.offer(new Point(1, 0, 100, 0));
        }
        
        if (board[0][1] != 1) { 
            minCost[0][1][1] = 100;
            pq.offer(new Point(0, 1, 100, 1));
        }

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (now.cost > minCost[now.y][now.x][now.direction]) {
                continue;
            }

            for (int i = 0; i < 4; i++) { 
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                int nextDirection = i;

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) continue;
                if (board[nextY][nextX] == 1) continue;

                int newCost = now.cost;
                if (now.direction == nextDirection) newCost += 100;
                 else newCost += 600; 

                if (newCost < minCost[nextY][nextX][nextDirection]) {
                    minCost[nextY][nextX][nextDirection] = newCost;
                    pq.offer(new Point(nextY, nextX, newCost, nextDirection));
                }
            }
        }

        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minResult = Math.min(minResult, minCost[N - 1][N - 1][i]);
        }

        return minResult;
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int cost;
        int direction; 

        public Point(int y, int x, int cost, int direction) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direction = direction;
        }

        @Override
        public int compareTo(Point point) {
            return this.cost - point.cost;
        }
    }
}