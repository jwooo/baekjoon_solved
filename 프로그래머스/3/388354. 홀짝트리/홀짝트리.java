class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int max = 1_000_000;
        int[] parent = new int[max + 1];
        int[] degree = new int[max + 1];
        int[] count = new int[max + 1];
        int[] size = new int[max + 1];

        for (int node : nodes) {
            parent[node] = node;
            size[node] = 1;
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            degree[a]++;
            degree[b]++;
            union(parent, size, a, b);
        }

        for (int node : nodes) {
            if ((node & 1) == (degree[node] & 1)) {
                count[find(parent, node)]++;
            }
        }

        int oddEven = 0;
        int reverseOddEven = 0;

        for (int node : nodes) {
            if (parent[node] == node) {
                if (count[node] == 1) {
                    oddEven++;
                }

                if (count[node] == size[node] - 1) {
                    reverseOddEven++;
                }
            }
        }

        return new int[]{oddEven, reverseOddEven};
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    private void union(int[] parent, int[] size, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a == b) {
            return;
        }

        if (size[a] < size[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        parent[b] = a;
        size[a] += size[b];
    }
}