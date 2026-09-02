class Solution {

    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;

        boolean[] hand = new boolean[n + 1];
        boolean[] candidate = new boolean[n + 1];

        int idx = n / 3;
        for (int i = 0; i < idx; i++) {
            hand[cards[i]] = true;
        }

        int round = 1;
        while (idx < n) {
            candidate[cards[idx]] = true;
            candidate[cards[idx + 1]] = true;
            idx += 2;

            if (usePair(hand, hand, target)) {
                round++;
                continue;
            }
            
            if (coin >= 1 && usePair(hand, candidate, target)) {
                coin--;
                round++;
                continue;
            }

            if (coin >= 2 && usePair(candidate, candidate, target)) {
                coin -= 2;
                round++;
                continue;
            }

            break;
        }

        return round;
    }

    private boolean usePair(boolean[] first, boolean[] second, int target) {
        int n = first.length - 1;
        for (int card = 1; card <= n; card++) {
            int pair = target - card;

            if (pair < 1 || pair > n) {
                continue;
            }

            if (first[card] && second[pair]) {
                first[card] = false;
                second[pair] = false;

                return true;
            }
        }

        return false;
    }
}