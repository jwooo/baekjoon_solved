class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;

        List<Boolean> greatestCandies = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            if (maxCandy < candies[i]) maxCandy = candies[i];
        }

        for (int i = 0; i < candies.length; i++) {
            boolean isGreatestCandy = false;

            if (maxCandy <= candies[i] + extraCandies) {
                isGreatestCandy = true;
            }

            greatestCandies.add(isGreatestCandy);
        }

        return greatestCandies;
    }
}