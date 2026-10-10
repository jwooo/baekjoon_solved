import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int n = rc.length;
        int m = rc[0].length;

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Deque<Deque<Integer>> middle = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            left.addLast(rc[i][0]);
            right.addLast(rc[i][m - 1]);

            Deque<Integer> row = new ArrayDeque<>();
            for (int j = 1; j < m - 1; j++) {
                row.addLast(rc[i][j]);
            }
            middle.addLast(row);
        }

        for (String operation : operations) {
            if (operation.equals("ShiftRow")) {
                middle.addFirst(middle.pollLast());
                left.addFirst(left.pollLast());
                right.addFirst(right.pollLast());
            } else {
                if (m == 2) {
                    int leftTop = left.pollFirst();
                    int rightBottom = right.pollLast();

                    left.addLast(rightBottom);
                    right.addFirst(leftTop);
                } else {
                    Deque<Integer> top = middle.peekFirst();
                    Deque<Integer> bottom = middle.peekLast();

                    int topRight = top.pollLast();
                    int bottomRight = right.pollLast();

                    top.addFirst(left.pollFirst());
                    right.addFirst(topRight);
                    bottom.addLast(bottomRight);
                    left.addLast(bottom.pollFirst());
                }
            }
        }

        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            answer[i][0] = left.pollFirst();

            Deque<Integer> row = middle.pollFirst();
            for (int j = 1; j < m - 1; j++) {
                answer[i][j] = row.pollFirst();
            }

            answer[i][m - 1] = right.pollFirst();
        }

        return answer;
    }
}