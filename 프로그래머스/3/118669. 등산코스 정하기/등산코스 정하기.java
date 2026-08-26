import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];

        for (int gate : gates) {
            isGate[gate] = true;
        }
        
        for (int summit : summits) {
            isSummit[summit] = true;
        }

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.to;
            int currentIntensity = current.weight;

            if (currentIntensity > intensity[u]) continue;
            if (isSummit[u]) continue;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.to;
                int w = neighbor.weight;

                if (isGate[v]) continue;

                int nextIntensity = Math.max(currentIntensity, w);

                if (nextIntensity < intensity[v]) {
                    intensity[v] = nextIntensity;
                    pq.offer(new Node(v, nextIntensity));
                }
            }
        }

        Arrays.sort(summits); 
        int bestSummit = -1;
        int minIntensity = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                bestSummit = summit;
            }
        }

        return new int[] { bestSummit, minIntensity };
    }
}