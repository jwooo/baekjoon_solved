import java.util.*;

class Solution {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int room;
        int mask;
        long dist;

        State(int room, int mask, long dist) {
            this.room = room;
            this.mask = mask;
            this.dist = dist;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        List<Edge>[] graph = new ArrayList[n + 1];
        List<Edge>[] reverse = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int cost = road[2];

            graph[from].add(new Edge(to, cost));
            reverse[to].add(new Edge(from, cost));
        }

        int[] trapIndex = new int[n + 1];
        Arrays.fill(trapIndex, -1);

        for (int i = 0; i < traps.length; i++) {
            trapIndex[traps[i]] = i;
        }

        int size = 1 << traps.length;
        long[][] dist = new long[n + 1][size];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[start][0] = 0;
        pq.offer(new State(start, 0, 0));

        while (!pq.isEmpty()) {
            State current = pq.poll();

            int room = current.room;
            int mask = current.mask;
            long cost = current.dist;

            if (cost != dist[room][mask]) {
                continue;
            }

            if (room == end) {
                return (int) cost;
            }

            boolean currentActive = isActive(room, mask, trapIndex);

            for (Edge edge : graph[room]) {
                boolean nextActive = isActive(edge.to, mask, trapIndex);

                if (currentActive != nextActive) {
                    continue;
                }

                int nextMask = mask;
                int index = trapIndex[edge.to];

                if (index != -1) {
                    nextMask ^= 1 << index;
                }

                long nextCost = cost + edge.cost;

                if (nextCost < dist[edge.to][nextMask]) {
                    dist[edge.to][nextMask] = nextCost;
                    pq.offer(new State(edge.to, nextMask, nextCost));
                }
            }

            for (Edge edge : reverse[room]) {
                boolean nextActive = isActive(edge.to, mask, trapIndex);

                if (currentActive == nextActive) {
                    continue;
                }

                int nextMask = mask;
                int index = trapIndex[edge.to];

                if (index != -1) {
                    nextMask ^= 1 << index;
                }

                long nextCost = cost + edge.cost;

                if (nextCost < dist[edge.to][nextMask]) {
                    dist[edge.to][nextMask] = nextCost;
                    pq.offer(new State(edge.to, nextMask, nextCost));
                }
            }
        }

        return -1;
    }

    private boolean isActive(int room, int mask, int[] trapIndex) {
        int index = trapIndex[room];

        return index != -1 && (mask & (1 << index)) != 0;
    }
}