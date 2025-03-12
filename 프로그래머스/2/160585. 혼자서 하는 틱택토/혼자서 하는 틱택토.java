class Solution {
    char[][] map = new char[3][3];
    int[] dy = {1, 0, 1, -1};
    int[] dx = {0, 1, 1, 1};

    public int solution(String[] board) {
        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
        }

        int oCount = 0;
        int xCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                oCount += map[i][j] == 'O' ? 1 : 0;
                xCount += map[i][j] == 'X' ? 1 : 0;
            }
        }

        if (oCount == xCount) return !isBingo('O') ? 1 : 0;
        else if (oCount == xCount + 1) return !isBingo('X') ? 1 : 0;
        else return 0;
    }

    private boolean isBingo(char c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < dy.length; k++) {
                    int count = 0;

                    for (int l = 0; l < 3; l++) {
                        int nowY = i + dy[k] * l;
                        int nowX = j + dx[k] * l;

                        if (nowY < 0 || nowY >= 3 || nowX < 0 || nowX >= 3) break;
                        if (map[nowY][nowX] != c) break;
                        count++;
                    }

                    if (count == 3) return true;
                }
            }
        }

        return false;
    }
}