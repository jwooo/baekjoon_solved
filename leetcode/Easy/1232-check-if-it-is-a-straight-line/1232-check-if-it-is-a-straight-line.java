class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            long x = coordinates[i][0] - coordinates[0][0];
            long y = coordinates[i][1] - coordinates[0][1];

            if (x * dy != y * dx) {
                return false;
            }
        }

        return true;
    }
}