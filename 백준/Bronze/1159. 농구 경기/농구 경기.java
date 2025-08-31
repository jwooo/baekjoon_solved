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
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char now = br.readLine().charAt(0);
            map.put(now, map.getOrDefault(now, 0) + 1);
        }

        List<Character> players = new ArrayList<>();
        for (Character key : map.keySet()) {
            Integer count = map.get(key);
            if (count < 5) {
                continue;
            }
            players.add(key);
        }

        Collections.sort(players);
        if (players.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            StringBuilder sb = new StringBuilder();
            players.forEach(sb::append);

            System.out.println(sb);
        }
    }
}
