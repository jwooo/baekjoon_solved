import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            int time = getTimeToStr(st.nextToken());

            queue.offer(new int[]{team, time});
        }

        int scoredTeam = 0;
        int lastWinTime = 0;
        int nowTime = 0;
        int[] scores = new int[3];
        int[] winTime = new int[3];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            scoredTeam = now[0];
            scores[scoredTeam]++;

            if (scores[scoredTeam] - scores[3 - scoredTeam] == 1) {
                lastWinTime = now[1];
            } else if (scores[scoredTeam] == scores[3 - scoredTeam]) {
                winTime[3 - scoredTeam] += now[1] - lastWinTime;
            }

            nowTime = now[1];
        }

        if (scores[1] > scores[2]) {
            winTime[1] += getTimeToStr("48:00") - lastWinTime;
        } else if (scores[2] > scores[1]) {
            winTime[2] += getTimeToStr("48:00") - lastWinTime;
        }

        System.out.println(getStrToTime(winTime[1]));
        System.out.println(getStrToTime(winTime[2]));
    }

    private int getTimeToStr(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private String getStrToTime(int time) {
        int hours = time / 60;
        int minutes = time % 60;

        StringBuilder sb = new StringBuilder();

        if (hours < 10) {
            sb.append(0);
        }
        sb.append(hours).append(":");

        if (minutes < 10) {
            sb.append(0);
        }
        sb.append(minutes);

        return sb.toString();
    }

}
