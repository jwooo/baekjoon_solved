import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
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
        int n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(p, d));

            maxDay = Math.max(maxDay, d);
        }

        Collections.sort(lectures);
        PriorityQueue<Integer> availableLectures = new PriorityQueue<>(Collections.reverseOrder());

        long totalPay = 0;
        int lectureIndex = 0;

        for (int day = maxDay; day >= 1; day--) {
            while (lectureIndex < n && lectures.get(lectureIndex).day >= day) {
                availableLectures.offer(lectures.get(lectureIndex).pay);
                lectureIndex++;
            }

            if (!availableLectures.isEmpty()) {
                totalPay += availableLectures.poll();
            }
        }

        System.out.println(totalPay);
    }

    static class Lecture implements Comparable<Lecture> {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.day == o.day) {
                return o.pay - this.pay;
            }

            return o.day - this.day;
        }
    }
}