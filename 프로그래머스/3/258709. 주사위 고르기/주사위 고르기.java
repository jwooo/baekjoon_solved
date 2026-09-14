import java.util.*;

class Solution {
    int n;
    int half;
    int[][] dice;

    List<Integer> bestCombination = new ArrayList<>();
    int maxWin = -1;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.n = dice.length;
        this.half = n / 2;

        selectDice(0, new ArrayList<>());

        int[] answer = new int[half];

        for (int i = 0; i < half; i++) {
            answer[i] = bestCombination.get(i) + 1;
        }

        return answer;
    }

    private void selectDice(int index, List<Integer> selected) {
        if (selected.size() == half) {
            calculateWin(selected);
            return;
        }

        if (index == n) {
            return;
        }

        selected.add(index);
        selectDice(index + 1, selected);
        selected.remove(selected.size() - 1);

        selectDice(index + 1, selected);
    }

    private void calculateWin(List<Integer> selected) {
        boolean[] isSelected = new boolean[n];

        for (int idx : selected) {
            isSelected[idx] = true;
        }

        List<Integer> aDice = new ArrayList<>();
        List<Integer> bDice = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSelected[i]) {
                aDice.add(i);
            } else {
                bDice.add(i);
            }
        }

        List<Integer> aSums = new ArrayList<>();
        List<Integer> bSums = new ArrayList<>();

        makeSums(aDice, 0, 0, aSums);
        makeSums(bDice, 0, 0, bSums);

        Collections.sort(bSums);

        int winCount = 0;
        for (int aSum : aSums) {
            winCount += lowerBound(bSums, aSum);
        }

        if (winCount > maxWin) {
            maxWin = winCount;
            bestCombination = new ArrayList<>(selected);
        }
    }

    private void makeSums(
            List<Integer> selectedDice,
            int depth,
            int sum,
            List<Integer> sums) {

        if (depth == selectedDice.size()) {
            sums.add(sum);
            return;
        }

        int diceIndex = selectedDice.get(depth);
        for (int value : dice[diceIndex]) {
            makeSums(
                    selectedDice,
                    depth + 1,
                    sum + value,
                    sums
            );
        }
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    
}