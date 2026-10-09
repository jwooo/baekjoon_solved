class Solution {
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;

        int[] head = new int[n + 1];
        int[] to = new int[n - 1];
        int[] next = new int[n - 1];

        java.util.Arrays.fill(head, -1);

        for (int i = 0; i < links.length; i++) {
            int a = links[i][0];
            int b = links[i][1];

            to[i] = b;
            next[i] = head[a];
            head[a] = i;
        }

        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0;
        int size = 0;

        stack[top++] = 1;

        while (top > 0) {
            int cur = stack[--top];
            order[size++] = cur;

            for (int e = head[cur]; e != -1; e = next[e]) {
                stack[top++] = to[e];
            }
        }

        long[] absent = new long[n + 1];
        long[] present = new long[n + 1];

        for (int i = size - 1; i >= 0; i--) {
            int cur = order[i];

            long sum = 0;
            long minDiff = Long.MAX_VALUE;
            boolean hasPresent = false;

            for (int e = head[cur]; e != -1; e = next[e]) {
                int child = to[e];

                if (absent[child] < present[child]) {
                    sum += absent[child];
                    minDiff = Math.min(minDiff, present[child] - absent[child]);
                } else {
                    sum += present[child];
                    hasPresent = true;
                }
            }

            present[cur] = sum + sales[cur - 1];

            if (head[cur] == -1) {
                absent[cur] = 0;
            } else if (hasPresent) {
                absent[cur] = sum;
            } else {
                absent[cur] = sum + minDiff;
            }
        }

        return (int) Math.min(absent[1], present[1]);
    }
}