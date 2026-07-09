class Solution {
    public int solution(int n, int w, int num) {

        int targetRow = (num - 1) / w;

        int targetCol;
        if (targetRow % 2 == 0) {
            targetCol = (num - 1) % w;
        } else {
            targetCol = w - 1 - (num - 1) % w;
        }

        int lastRow = (n - 1) / w;
        int remain = n % w;

        int columnHeight;

        if (remain == 0) {
            columnHeight = lastRow + 1;
        } else {
            boolean exist;

            if (lastRow % 2 == 0) {
                exist = targetCol < remain;
            } else {
                exist = targetCol >= w - remain;
            }

            columnHeight = exist ? lastRow + 1 : lastRow;
        }

        return columnHeight - targetRow;
    }
}