import java.util.*;
import java.util.function.Function;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        List<Integer> candidates = new ArrayList<>();

        for (int num = 1000; num <= 9999; num++) {
            if (isValid(num)) {
                candidates.add(num);
            }
        }

        int guess = 1123;

        for (int turn = 0; turn < n; turn++) {
            if (candidates.size() == 1) {
                return candidates.get(0);
            }

            if (turn > 0) {
                guess = choose(candidates);
            }

            String result = submit.apply(guess);
            int strikes = result.charAt(0) - '0';
            int balls = result.charAt(3) - '0';
            int target = strikes * 5 + balls;

            List<Integer> next = new ArrayList<>();

            for (int candidate : candidates) {
                if (getScore(candidate, guess) == target) {
                    next.add(candidate);
                }
            }

            candidates = next;
        }

        return candidates.get(0);
    }

    private boolean isValid(int num) {
        int mask = 0;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 0 || (mask & (1 << digit)) != 0) {
                return false;
            }

            mask |= 1 << digit;
            num /= 10;
        }

        return true;
    }

    private int choose(List<Integer> candidates) {
        int bestGuess = 1000;
        int minMax = Integer.MAX_VALUE;
        long minSum = Long.MAX_VALUE;

        for (int guess = 1000; guess <= 9999; guess++) {
            int[] counts = new int[25];

            for (int candidate : candidates) {
                counts[getScore(candidate, guess)]++;
            }

            int max = 0;
            long sum = 0;

            for (int count : counts) {
                max = Math.max(max, count);
                sum += (long) count * count;
            }

            if (max < minMax || (max == minMax && sum < minSum)) {
                minMax = max;
                minSum = sum;
                bestGuess = guess;
            }
        }

        return bestGuess;
    }

    private int getScore(int password, int guess) {
        int mask = 0;
        int temp = password;

        while (temp > 0) {
            mask |= 1 << (temp % 10);
            temp /= 10;
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 4; i++) {
            int p = password % 10;
            int g = guess % 10;

            if (p == g) {
                strikes++;
            } else if ((mask & (1 << g)) != 0) {
                balls++;
            }

            password /= 10;
            guess /= 10;
        }

        return strikes * 5 + balls;
    }
}