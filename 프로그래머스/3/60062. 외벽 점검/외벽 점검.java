import java.util.*;

class Solution {
    static int answer;
    static int[] weak;
    static int[] dist;
    static boolean[] visited;

    public int solution(int n, int[] weak, int[] dist) {
        this.weak = new int[weak.length * 2];
        this.dist = dist;

        for (int i = 0; i < weak.length; i++) {
            this.weak[i] = weak[i];
            this.weak[i + weak.length] = weak[i] + n;
        }

        answer = dist.length + 1;
        visited = new boolean[dist.length];

        permutation(new int[dist.length], 0);

        return answer == dist.length + 1 ? -1 : answer;
    }

    static void permutation(int[] order, int depth) {

        if (depth > 0) {
            check(order, depth);
        }

        if (depth == dist.length) {
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            order[depth] = dist[i];

            permutation(order, depth + 1);

            visited[i] = false;
        }
    }

    static void check(int[] order, int count) {
        int wLen = weak.length / 2;

        for (int start = 0; start < wLen; start++) {

            int friend = 0;
            int current = weak[start];

            int index = start;

            while (friend < count && index < start + wLen) {
                int limit = current + order[friend];

                while (index < start + wLen
                        && weak[index] <= limit) {
                    index++;
                }

                friend++;

                if (index < start + wLen) {
                    current = weak[index];
                }
            }

            if (index == start + wLen) {
                answer = Math.min(answer, friend);
            }
        }
    }
}
