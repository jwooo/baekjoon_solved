import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int answer = 0;
        Stack<String> rooms = new Stack<>();
        Set<String> playedUsers = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String user = br.readLine();

            if (playedUsers.contains(user)) {
                continue;
            }

            rooms.push(user);

            if (isFull(game, rooms)) {
                while (!rooms.isEmpty()) {
                    playedUsers.add(rooms.pop());
                }

                answer++;
            }

        }

        System.out.println(answer);
    }

    private boolean isFull(String game, Stack<String> rooms) {
        if (game.equals("Y")) {
            return rooms.size() == 1;
        } else if (game.equals("F")) {
            return rooms.size() == 2;
        } else {
            return rooms.size() == 3;
        }
    }

}