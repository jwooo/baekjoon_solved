class Solution {
    public int[] solution(int[][] edges) {

        int MAX = 1_000_000;

        int[] inDegree = new int[MAX + 1];
        int[] outDegree = new int[MAX + 1];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            outDegree[from]++;
            inDegree[to]++;
        }

        int created = 0;

        for (int i = 1; i <= MAX; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                created = i;
                break;
            }
        }

        int donut = 0;
        int stick = 0;
        int eight = 0;

        for (int i = 1; i <= MAX; i++) {
            if (outDegree[i] == 0 && inDegree[i] > 0) {
                stick++;
            }

            if (outDegree[i] == 2 && inDegree[i] >= 2) {
                eight++;
            }
        }

        int total = outDegree[created];

        donut = total - stick - eight;

        return new int[]{created, donut, stick, eight};
    }
}