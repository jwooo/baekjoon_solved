import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Node> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (!map.containsKey(now)) {
                Node node = new Node(now, i, 1);
                map.put(now, node);
            } else {
                Node node = map.get(now);
                node.addFrequency();
            }
        }

        List<Node> nodes = new ArrayList<>();
        for (int key : map.keySet()) {
            nodes.add(map.get(key));
        }

        Collections.sort(nodes);

        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            for (int i = 0; i < node.frequency; i++) {
                sb.append(node.node).append(" ");
            }
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int node;
        int firstIndex;
        int frequency;

        public Node(int node, int firstIndex, int frequency) {
            this.node = node;
            this.firstIndex = firstIndex;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node o) {
            if (this.frequency == o.frequency) {
                return this.firstIndex - o.firstIndex;
            }

            return o.frequency - this.frequency;
        }

        public void addFrequency() {
            this.frequency++;
        }
    }
}
