class Solution {

    int index = 0;

    public int solution(String dartResult) {

        int[] scores = new int[3];
        int round = 0;

        while (index < dartResult.length()) {
            int number = findNumber(dartResult);

            int area = findArea(dartResult);
            int score = (int) Math.pow(number, area);

            index++;

            if (index < dartResult.length()) {
                char option = dartResult.charAt(index);

                if (option == '*') {
                    score *= 2;

                    if (round > 0) {
                        scores[round - 1] *= 2;
                    }
                    index++;
                } else if (option == '#') {
                    score *= -1;
                    index++;
                }
            }
            
            scores[round++] = score;
        }

        return scores[0] + scores[1] + scores[2];
    }

    private int findNumber(String d) {
        StringBuilder sb = new StringBuilder();

        while (index < d.length() && isNumeric(d.charAt(index))) {
            sb.append(d.charAt(index));
            index++;
        }

        return Integer.parseInt(sb.toString());
    }

    private int findArea(String d) {
        char c = d.charAt(index);

        if (c == 'S') {
            return 1;
        } else if (c == 'D') {
            return 2;
        } else {
            return 3;
        }
    }

    private boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }
}