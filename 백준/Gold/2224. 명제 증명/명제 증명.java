import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char p = line.charAt(0);
            char q = line.charAt(5);

            if (p != q) {
                graph.computeIfAbsent(p, k -> new HashSet<>()).add(q);
            }
        }

        List<String> result = new ArrayList<>();
        List<Character> startNodes = new ArrayList<>(graph.keySet());
        Collections.sort(startNodes);

        for (char startNode : startNodes) {
            Queue<Character> queue = new LinkedList<>();
            Set<Character> visited = new HashSet<>();

            queue.offer(startNode);
            while (!queue.isEmpty()) {
                char now = queue.poll();

                if (graph.containsKey(now)) {
                    for (char next : graph.get(now)) {
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }

            for (char endNode : visited) {
                if (startNode != endNode) {
                    result.add(startNode + " => " + endNode);
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}