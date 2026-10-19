import java.util.*;

class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int n = target.length;
        List<Integer>[] children = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            children[edge[0]].add(edge[1]);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(children[i]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (children[i].isEmpty()) {
                leaves.add(i);
            }
        }

        int[] pointer = new int[n + 1];
        int[] count = new int[n + 1];
        List<Integer> order = new ArrayList<>();

        while (true) {
            boolean done = true;

            for (int leaf : leaves) {
                int need = (target[leaf - 1] + 2) / 3;

                if (count[leaf] < need) {
                    done = false;
                    break;
                }
            }

            if (done) {
                break;
            }

            List<Integer> path = new ArrayList<>();
            int current = 1;

            while (!children[current].isEmpty()) {
                path.add(current);
                current = children[current].get(pointer[current]);
            }

            count[current]++;
            order.add(current);

            if (target[current - 1] == 0 ||
                count[current] > target[current - 1]) {
                return new int[]{-1};
            }

            for (int node : path) {
                pointer[node] = (pointer[node] + 1) % children[node].size();
            }
        }

        int[] remaining = target.clone();
        int[] used = new int[n + 1];
        int[] answer = new int[order.size()];

        for (int i = 0; i < order.size(); i++) {
            int leaf = order.get(i);
            int slots = count[leaf] - used[leaf] - 1;
            int value;

            if (remaining[leaf - 1] - 1 <= slots * 3) {
                value = 1;
            } else if (remaining[leaf - 1] - 2 <= slots * 3) {
                value = 2;
            } else {
                value = 3;
            }

            answer[i] = value;
            remaining[leaf - 1] -= value;
            used[leaf]++;
        }

        return answer;
    }
}