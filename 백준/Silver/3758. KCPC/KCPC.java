import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());

            int teamCount = Integer.parseInt(st.nextToken());
            int problemCount = Integer.parseInt(st.nextToken());
            int teamId = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            TeamScore[] teamScores = new TeamScore[teamCount];
            for (int j = 0; j < teamScores.length; j++) {
                teamScores[j] = new TeamScore(j + 1, problemCount);
            }

            for (int j = 0; j < m; j++) {
                solveProblems(teamScores, j);
            }

            Arrays.sort(teamScores);
            for (int j = 0; j < teamScores.length; j++) {
                TeamScore teamScore = teamScores[j];

                if (teamScore.teamId == teamId) {
                    sb.append(j + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb.toString().trim());
    }

    public void solveProblems(TeamScore[] teamScores, int submission) throws IOException {
        st = new StringTokenizer(br.readLine());

        int teamId = Integer.parseInt(st.nextToken());
        int problemId = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());

        TeamScore teamScore = teamScores[teamId - 1];

        teamScore.lastSubmission = submission;
        teamScore.submissionCount++;

        if (teamScore.points[problemId - 1] < point) {
            int temp = teamScore.points[problemId - 1];

            teamScore.points[problemId - 1] = point;
            teamScore.pointSum += (point - temp);
        }
    }

    static class TeamScore implements Comparable<TeamScore> {
        int teamId;
        int[] points;
        int pointSum;
        int submissionCount;
        int lastSubmission;

        public TeamScore(int teamId, int problemCount) {
            this.teamId = teamId;
            this.points = new int[problemCount];
        }

        @Override
        public int compareTo(TeamScore o) {
            if (this.pointSum != o.pointSum) {
                return o.pointSum - this.pointSum;
            }

            if (this.submissionCount != o.submissionCount) {
                return this.submissionCount - o.submissionCount;
            }

            return this.lastSubmission - o.lastSubmission;
        }
    }

}