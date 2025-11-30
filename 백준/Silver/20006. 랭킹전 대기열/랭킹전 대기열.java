import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        int m = Integer.parseInt(st.nextToken());

        int roomId = 1;
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            User user = new User(st);
            Room room = findRoom(user.level, m, rooms);

            if (room != null) {
                room.addUser(user);
            } else {
                room = new Room(roomId++, user.level);
                room.addUser(user);
                rooms.add(room);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.isFull(m)) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            Collections.sort(room.users);
            for (User user : room.users) {
                sb.append(user.level).append(" ").append(user.name).append("\n");
            }

        }

        System.out.println(sb.toString().trim());
    }

    private Room findRoom(int level, int m, List<Room> rooms) {
        for (Room room : rooms) {
            if (room.canEnter(level, m)) {
                return room;
            }
        }

        return null;
    }

    static class Room {
        int id;
        int levelLimitation;
        List<User> users;

        public Room(int id, int levelLimitation) {
            this.id = id;
            this.levelLimitation = levelLimitation;
            this.users = new ArrayList<>();
        }

        private void addUser(User user) {
            users.add(user);
        }

        public boolean canEnter(int level, int roomLimit) {
            return levelLimitation - 10 <= level && levelLimitation + 10 >= level && users.size() < roomLimit;
        }

        public boolean isFull(int roomLimit) {
            return users.size() == roomLimit;
        }
    }

    static class User implements Comparable<User> {
        int level;
        String name;

        public User(StringTokenizer st) {
            this.level = Integer.parseInt(st.nextToken());
            this.name = st.nextToken();
        }

        @Override
        public int compareTo(User o) {
            return this.name.compareTo(o.name);
        }
    }
}