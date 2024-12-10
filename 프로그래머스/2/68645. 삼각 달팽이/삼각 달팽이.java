class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] matrix = new int[n][n];
        
        int y = - 1;
        int x = 0;
        int now = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    ++y;
                } else if (i % 3 == 1) {
                    ++x;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                
                matrix[y][x] = now++;
            }
        }
        
        int k = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}