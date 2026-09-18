
class Solution {
    public int solution(String[] lines) {
        int n = lines.length;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            String[] log = lines[i].split(" ");

            int end = toMillis(log[1]);
            int duration = (int) (Double.parseDouble(
                log[2].substring(0, log[2].length() - 1)
            ) * 1000);

            ends[i] = end;
            starts[i] = end - duration + 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, count(starts[i], starts, ends));
            answer = Math.max(answer, count(ends[i], starts, ends));
        }

        return answer;
    }

    private int count(int time, int[] starts, int[] ends) {
        int count = 0;
        int windowEnd = time + 999;

        for (int i = 0; i < starts.length; i++) {
            if (starts[i] <= windowEnd && ends[i] >= time) {
                count++;
            }
        }

        return count;
    }

    private int toMillis(String time) {
        String[] hms = time.split(":");

        int hour = Integer.parseInt(hms[0]);
        int minute = Integer.parseInt(hms[1]);
        double second = Double.parseDouble(hms[2]);

        return (int) (
            hour * 3600000L
            + minute * 60000L
            + second * 1000
        );
    }
}