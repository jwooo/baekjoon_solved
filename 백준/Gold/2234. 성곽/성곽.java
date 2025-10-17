import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static int[][] map;
    static char[][] room;
    static boolean[][] visited;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        room = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char roomName = 'a';
        int maxRoomSize = Integer.MIN_VALUE;
        Map<Character, Integer> roomInfo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    int roomSize = 1;
                    room[i][j] = roomName;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});

                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int y = now[0];
                        int x = now[1];
                        String wall = convertToBinary(map[y][x]);

                        for (int k = 0; k < 4; k++) {
                            int nowWall = wall.charAt(k) - '0';

                            int[] nextIndex = getNextIndex(y, x, k);

                            int nextY = nextIndex[0];
                            int nextX = nextIndex[1];

                            if (nowWall == 1) {
                                continue;
                            }
                            if (nextY < 0 || nextY >= n || nextX < 0 || nextY >= m) {
                                continue;
                            }
                            if (visited[nextY][nextX]) {
                                continue;
                            }

                            queue.offer(new int[]{nextY, nextX});
                            visited[nextY][nextX] = true;
                            room[nextY][nextX] = roomName;
                            roomSize++;
                        }
                    }

                    maxRoomSize = Math.max(maxRoomSize, roomSize);
                    roomInfo.put(roomName++, roomSize);
                }
            }
        }

        int maxBrokenRoomSize = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nowRoomSize = roomInfo.get(room[i][j]);

                for (int k = 0; k < 4; k++) {
                    int[] nextIndex = getNextIndex(i, j, k);
                    int nextY = nextIndex[0];
                    int nextX = nextIndex[1];

                    if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                        continue;
                    }
                    if (room[i][j] == room[nextY][nextX]) {
                        continue;
                    }

                    int nextRoomSize = roomInfo.get(room[nextY][nextX]);
                    maxBrokenRoomSize = Math.max(maxBrokenRoomSize, nowRoomSize + nextRoomSize);
                }
            }
        }

        System.out.println(roomInfo.size());
        System.out.println(maxRoomSize);
        System.out.println(maxBrokenRoomSize);
    }

    private String convertToBinary(int number) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            sb.append(number % 2);
            number /= 2;
        }

        if (sb.length() < 4) {
            for (int i = sb.length(); i < 4; i++) {
                sb.append(0);
            }
        }

        return sb.reverse().toString();
    }

    private int[] getNextIndex(int y, int x, int direction) {
        int[] nextIndex = new int[2];

        if (direction == 0) {
            nextIndex[0] = y + 1;
            nextIndex[1] = x;
        } else if (direction == 1) {
            nextIndex[0] = y;
            nextIndex[1] = x + 1;
        } else if (direction == 2) {
            nextIndex[0] = y - 1;
            nextIndex[1] = x;
        } else {
            nextIndex[0] = y;
            nextIndex[1] = x - 1;
        }

        return nextIndex;
    }
}