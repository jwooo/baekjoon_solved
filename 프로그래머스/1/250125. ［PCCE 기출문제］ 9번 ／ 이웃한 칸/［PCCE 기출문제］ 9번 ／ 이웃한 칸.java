class Solution {
    
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int nextY = h + dy[i];
            int nextX = w + dx[i];
            
            if (nextY < 0 || nextY >= board.length || nextX < 0 || nextX >= board[0].length) continue;
            if (board[nextY][nextX].equals(color)) answer++;
        }
        
        return answer;
    }
}