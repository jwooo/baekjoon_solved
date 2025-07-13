import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    Map<String, Node> parent;
    StringBuilder answer = new StringBuilder();

    public void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            parent = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String nodeA = st.nextToken();
                String nodeB = st.nextToken();

                union(nodeA, nodeB);
            }
        }

        System.out.println(answer);
    }

    private void union(String nameA, String nameB) {
        Node nodeA = find(nameA);
        Node nodeB = find(nameB);

        if (!nodeA.name.equals(nodeB.name)) {
            parent.put(nodeB.name, nodeA);
            nodeA.size += nodeB.size;
        }

        answer.append(nodeA.size).append("\n");
    }

    private Node find(String name) {
        if (!parent.containsKey(name)) {
            parent.put(name, new Node(name, 1));
            return parent.get(name);
        }

        Node now = parent.get(name);
        if (now.name.equals(name)) {
            return now;
        } else {
            parent.put(name, find(now.name));
            return parent.get(name);
        }
    }

    static class Node {
        String name;
        int size;

        public Node(String name, int size) {
            this.name = name;
            this.size = size;
        }
    }

}
