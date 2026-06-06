import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];
            findAndMove(board, move, basket);
        }
        
        return answer;
    }
    
    private void findAndMove(int[][] board, int o, Stack<Integer> stack) {
        for (int i = 0; i < board.length; i++) {
            int now = board[i][o - 1];
            
            if (now != 0) {
                moveToBasket(now, stack);
                board[i][o - 1] = 0;
                return;
            }
        }
    }
    
    private void moveToBasket(int now, Stack<Integer> stack) {
        if (!stack.isEmpty() && stack.peek() == now) {
            answer += 2;
            stack.pop();
        } else {
            stack.push(now);
        }
    }
}