import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
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

        Queue<Emoticon> queue = new LinkedList<>();
        queue.offer(new Emoticon(1, 0, 0));

        Set<String> events = new HashSet<>();

        while (!queue.isEmpty()) {
            Emoticon now = queue.poll();

            for (int i = 0; i < 3; i++) {
                if (now.isPossibleNext(i)) {
                    Emoticon next = now.createNextEmoticon(i);
                    String event = next.toEventString(i);

                    if (events.contains(event)) {
                        continue;
                    }
                    if (next.emoticons == n) {
                        System.out.println(next.times);
                        return;
                    }

                    queue.offer(next);
                    events.add(event);
                }
            }
        }
    }

    static class Emoticon {
        int emoticons;
        int clipboards;
        int times;

        public Emoticon(int emoticons, int clipboards, int times) {
            this.emoticons = emoticons;
            this.clipboards = clipboards;
            this.times = times;
        }

        public boolean isPossibleNext(int event) {
            if (event != 1 && emoticons > 0) {
                return true;
            }
            if (event == 1 && clipboards > 0) {
                return true;
            }

            return false;
        }

        public Emoticon createNextEmoticon(int event) {
            int nextEmoticon = emoticons;
            int nextClipboards = clipboards;

            if (event == 0) {   // 저장
                nextClipboards = emoticons;
            } else if (event == 1) {    // 붙여넣기
                nextEmoticon += clipboards;
            } else {    // 삭제
                nextEmoticon -= 1;
            }

            return new Emoticon(nextEmoticon, nextClipboards, times + 1);
        }

        public String toEventString(int event) {
            return emoticons + ", " + clipboards + ", " + event;
        }
    }

}
