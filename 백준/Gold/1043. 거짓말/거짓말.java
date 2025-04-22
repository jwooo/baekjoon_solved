import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int membersCount = Integer.parseInt(st.nextToken());
        boolean[] knows = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < membersCount; i++) {
            int member = Integer.parseInt(st.nextToken());
            knows[member] = true;
            queue.offer(member);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int partyMemberCount = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();

            for (int j = 0; j < partyMemberCount; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }

            parties.add(party);
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> party : parties) {
            for (int i = 0; i < party.size(); i++) {
                for (int j = i + 1; j < party.size(); j++) {
                    int u = party.get(i);
                    int v = party.get(j);

                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : adj.get(now)) {
                if (!knows[next]) {
                    knows[next] = true;
                    queue.offer(next);
                }
            }
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            boolean ok = true;
            for (int p : party) {
                if (knows[p]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}