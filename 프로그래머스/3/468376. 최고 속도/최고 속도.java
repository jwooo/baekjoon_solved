import java.util.*;

class Solution {
    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return 31 * Long.hashCode(x) + Long.hashCode(y);
        }
    }

    static class Road {
        Point a, b, mid;
        boolean horizontal;
        List<Point> points = new ArrayList<>();

        Road(int[] road) {
            a = new Point(road[0], road[1]);
            b = new Point(road[2], road[3]);
            mid = new Point(
                ((long) road[0] + road[2]) / 2,
                ((long) road[1] + road[3]) / 2
            );
            horizontal = road[1] == road[3];

            points.add(a);
            points.add(b);
            points.add(mid);
        }

        boolean contains(Point p) {
            if (horizontal) {
                return p.y == a.y && p.x >= a.x && p.x <= b.x;
            }
            return p.x == a.x && p.y >= a.y && p.y <= b.y;
        }
    }

    static class State {
        int node;
        int speed;

        State(int node, int speed) {
            this.node = node;
            this.speed = speed;
        }
    }

    public int[] solution(int[][] city, int[][] road) {
        int n = city.length;
        int m = road.length;

        Road[] roads = new Road[m];
        Map<Point, Integer> cameras = new HashMap<>();

        for (int i = 0; i < m; i++) {
            roads[i] = new Road(road[i]);
            Point mid = roads[i].mid;
            cameras.put(mid, Math.min(
                cameras.getOrDefault(mid, Integer.MAX_VALUE),
                road[i][4]
            ));
        }

        for (int i = 0; i < n; i++) {
            Point p = new Point(city[i][0], city[i][1]);
            for (Road r : roads) {
                if (r.contains(p)) {
                    r.points.add(p);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                Road a = roads[i];
                Road b = roads[j];

                if (a.horizontal != b.horizontal) {
                    Road h = a.horizontal ? a : b;
                    Road v = a.horizontal ? b : a;
                    Point p = new Point(v.a.x, h.a.y);

                    if (h.contains(p) && v.contains(p)) {
                        h.points.add(p);
                        v.points.add(p);
                    }
                } else {
                    addSharedPoint(a, b, a.a);
                    addSharedPoint(a, b, a.b);
                    addSharedPoint(a, b, b.a);
                    addSharedPoint(a, b, b.b);
                }
            }
        }

        Map<Point, Integer> ids = new HashMap<>();

        for (Road r : roads) {
            for (Point p : r.points) {
                if (!ids.containsKey(p)) {
                    ids.put(p, ids.size());
                }
            }
        }

        int size = ids.size();
        List<Integer>[] graph = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }

        for (Road r : roads) {
            if (r.horizontal) {
                r.points.sort((p1, p2) -> Long.compare(p1.x, p2.x));
            } else {
                r.points.sort((p1, p2) -> Long.compare(p1.y, p2.y));
            }

            int prev = -1;
            Point prevPoint = null;

            for (Point p : r.points) {
                int id = ids.get(p);

                if (prev != -1 && !p.equals(prevPoint)) {
                    graph[prev].add(id);
                    graph[id].add(prev);
                }

                prev = id;
                prevPoint = p;
            }
        }

        int[] cameraLimit = new int[size];
        Arrays.fill(cameraLimit, Integer.MAX_VALUE);

        for (Map.Entry<Point, Integer> entry : cameras.entrySet()) {
            int id = ids.get(entry.getKey());
            cameraLimit[id] = Math.min(cameraLimit[id], entry.getValue());
        }

        int[] cityNode = new int[n];

        for (int i = 0; i < n; i++) {
            cityNode[i] = ids.get(new Point(city[i][0], city[i][1]));
        }

        boolean[] safe = new boolean[size];
        Queue<Integer> queue = new ArrayDeque<>();
        int start = cityNode[0];

        safe[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!safe[next] && cameraLimit[next] == Integer.MAX_VALUE) {
                    safe[next] = true;
                    queue.offer(next);
                }
            }
        }

        int[] best = new int[size];
        Arrays.fill(best, -1);
        best[start] = Integer.MAX_VALUE;

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.speed, a.speed)
        );

        pq.offer(new State(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.speed != best[current.node]) {
                continue;
            }

            for (int next : graph[current.node]) {
                int nextSpeed = Math.min(
                    current.speed,
                    cameraLimit[next]
                );

                if (nextSpeed > best[next]) {
                    best[next] = nextSpeed;
                    pq.offer(new State(next, nextSpeed));
                }
            }
        }

        int[] answer = new int[n - 1];

        for (int i = 1; i < n; i++) {
            answer[i - 1] = safe[cityNode[i]] ? 0 : best[cityNode[i]];
        }

        return answer;
    }

    private void addSharedPoint(Road a, Road b, Point p) {
        if (a.contains(p) && b.contains(p)) {
            a.points.add(p);
            b.points.add(p);
        }
    }
}