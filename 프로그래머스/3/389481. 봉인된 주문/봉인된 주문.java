import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        long[] banNumbers = new long[bans.length];

        for (int i = 0; i < bans.length; i++) {
            banNumbers[i] = encode(bans[i]);
        }

        Arrays.sort(banNumbers);

        long target = n;

        for (long ban : banNumbers) {
            if (ban <= target) {
                target++;
            } else {
                break;
            }
        }

        return decode(target);
    }

    private long encode(String s) {
        long number = 0;

        for (char c : s.toCharArray()) {
            number = number * 26 + (c - 'a' + 1);
        }

        return number;
    }

    private String decode(long number) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            number--;

            int index = (int) (number % 26);
            sb.append((char) ('a' + index));

            number /= 26;
        }

        return sb.reverse().toString();
    }
}