import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : path) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        int[] before = new int[n];
        int[] save = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] blocked = new boolean[n];

        for (int[] o : order) {
            before[o[1]] = o[0];
            save[o[0]] = o[1];
        }

        if (before[0] != 0) {
            return false;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            int next = save[curr];
            if (next != 0 && blocked[next]) {
                visited[next] = true;
                q.add(next);
            }

            for (int nbr : graph.get(curr)) {
                if (visited[nbr]) {
                    continue;
                }
                if (before[nbr] != 0 && !visited[before[nbr]]) {
                    blocked[nbr] = true;
                } else {
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }

        return count == n;
    }
}