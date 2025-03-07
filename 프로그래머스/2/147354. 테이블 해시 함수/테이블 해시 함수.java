import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (i, j) -> {
            if (i[col - 1] != j[col - 1]) return Integer.compare(i[col - 1], j[col - 1]);
            else return Integer.compare(j[0], i[0]);
        });
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = row_begin - 1; i < row_end; i++) {
            int s = 0;
            for (int j = 0; j < data[i].length; j++) {
                s += data[i][j] % (i + 1);
            }
            
            queue.offer(s);
        }
        
        answer = queue.poll();
        while (!queue.isEmpty()) {
            answer = answer ^ queue.poll();
        }
        
        return answer;
    }
}