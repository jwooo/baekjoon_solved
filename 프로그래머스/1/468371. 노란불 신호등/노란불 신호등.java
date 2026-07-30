class Solution {

    public int solution(int[][] signals) {
        int lcm = 1;

        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            lcm = lcm(lcm, cycle);
        }

        for (int t = 1; t <= lcm; t++) {
            boolean ok = true;

            for (int[] signal : signals) {
                int green = signal[0];
                int yellow = signal[1];
                int red = signal[2];

                int cycle = green + yellow + red;
                int pos = (t - 1) % cycle;

                if (!(pos >= green && pos < green + yellow)) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                return t;
            }
        }

        return -1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}