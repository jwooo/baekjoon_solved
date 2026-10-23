import java.util.*;

class Solution {
    int[] first;
    int[] second;

    public int solution(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cells = n * m;
        int nodes = cells * 2;

        first = new int[nodes];
        second = new int[nodes];
        Arrays.fill(first, -1);
        Arrays.fill(second, -1);

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                addEdge(
                    2 * ((r - 1) * m + c) + 1,
                    2 * (r * m + c)
                );
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m - 1; c++) {
                int left = 2 * (r * m + c)
                        + (grid[r][c] == 1 ? 1 : 0);
                int right = 2 * (r * m + c + 1)
                        + (grid[r][c + 1] == 1 ? 0 : 1);

                addEdge(left, right);
            }
        }

        boolean[] visited = new boolean[nodes];
        int[] sequence = new int[nodes];
        int[] frequency = new int[cells];
        int answer = 0;

        for (int i = 0; i < nodes; i++) {
            if (visited[i] || second[i] != -1) {
                continue;
            }

            int length = 0;
            int current = i;
            int previous = -1;

            while (current != -1 && !visited[current]) {
                visited[current] = true;
                sequence[length++] = current;

                int next = -1;

                if (first[current] != -1 && first[current] != previous) {
                    next = first[current];
                } else if (second[current] != -1
                        && second[current] != previous) {
                    next = second[current];
                }

                previous = current;
                current = next;
            }

            answer = Math.max(
                answer,
                longest(sequence, length, false, frequency)
            );
        }

        for (int i = 0; i < nodes; i++) {
            if (visited[i]) {
                continue;
            }

            int length = 0;
            int current = i;
            int previous = -1;

            while (!visited[current]) {
                visited[current] = true;
                sequence[length++] = current;

                int next = first[current] != previous
                        ? first[current]
                        : second[current];

                previous = current;
                current = next;
            }

            answer = Math.max(
                answer,
                longest(sequence, length, true, frequency)
            );
        }

        return answer;
    }

    private void addEdge(int u, int v) {
        if (first[u] == -1) {
            first[u] = v;
        } else {
            second[u] = v;
        }

        if (first[v] == -1) {
            first[v] = u;
        } else {
            second[v] = u;
        }
    }

    private int longest(
        int[] sequence,
        int length,
        boolean circular,
        int[] frequency
    ) {
        int left = 0;
        int answer = 0;
        int limit = circular ? length * 2 : length;

        for (int i = 0; i < limit; i++) {
            int index = circular ? i % length : i;
            int cell = sequence[index] / 2;

            while (frequency[cell] > 0
                    || (circular && i - left + 1 > length)) {
                int removeIndex = circular ? left % length : left;
                int removeCell = sequence[removeIndex] / 2;

                frequency[removeCell]--;
                left++;
            }

            frequency[cell]++;
            answer = Math.max(answer, i - left + 1);
        }

        for (int i = left; i < limit; i++) {
            int index = circular ? i % length : i;
            frequency[sequence[index] / 2]--;
        }

        return answer;
    }
}