import java.util.*;

class Solution {

    static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {

        List<Point> points = new ArrayList<>();

        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        int n = line.length;

        for (int i = 0; i < n - 1; i++) {

            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];

            for (int j = i + 1; j < n; j++) {

                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long denominator = A * D - B * C;

                if (denominator == 0)
                    continue;

                long xNumerator = B * F - E * D;
                long yNumerator = E * C - A * F;

                if (xNumerator % denominator != 0)
                    continue;
                if (yNumerator % denominator != 0)
                    continue;

                long x = xNumerator / denominator;
                long y = yNumerator / denominator;

                points.add(new Point(x, y));

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] map = new char[height][width];

        for (int i = 0; i < height; i++) {
            Arrays.fill(map[i], '.');
        }

        for (Point p : points) {
            int row = (int) (maxY - p.y);
            int col = (int) (p.x - minX);

            map[row][col] = '*';
        }

        String[] answer = new String[height];

        for (int i = 0; i < height; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}