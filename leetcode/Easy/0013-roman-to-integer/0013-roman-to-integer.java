class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int start = 0;
        Map<String, Integer> roman = initRomanTable();

        while (start < s.length()) {
            int nowValue = roman.get(s.substring(start, start + 1));

            if (!(start == s.length() - 1)) {
                int nextValue = roman.get(s.substring(start + 1, start + 2));

                if (nowValue == 1) {
                    if ((nextValue == 5) || (nextValue == 10)) {
                        nowValue = nextValue - nowValue;
                        start++;
                    }
                } else if (nowValue == 10) {
                    if ((nextValue == 50) || (nextValue == 100)) {
                        nowValue = nextValue - nowValue;
                        start++;
                    }
                } else if (nowValue == 100) {
                    if ((nextValue == 500) || (nextValue == 1000)) {
                        nowValue = nextValue - nowValue;
                        start++;
                    }
                }
            }

            result += nowValue;
            start++;
        }

        return result;
    }

    private Map<String, Integer> initRomanTable() {
        Map<String, Integer> roman = new HashMap<>();

        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);

        return roman;
    }
}