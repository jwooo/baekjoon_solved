import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<Integer> candidates = new ArrayList<>();

        for (int base = 2; base <= 9; base++) {
            if (isPossibleBase(expressions, base)) {
                candidates.add(base);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String expression : expressions) {
            String[] parts = expression.split(" ");

            String aStr = parts[0];
            String op = parts[1];
            String bStr = parts[2];
            String cStr = parts[4];

            if (!cStr.equals("X")) {
                continue;
            }

            String result = null;
            boolean same = true;

            for (int base : candidates) {
                int a = toDecimal(aStr, base);
                int b = toDecimal(bStr, base);

                int value;

                if (op.equals("+")) {
                    value = a + b;
                } else {
                    value = a - b;
                }

                String converted = fromDecimal(value, base);

                if (result == null) {
                    result = converted;
                } else if (!result.equals(converted)) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                result = "?";
            }

            answer.add(aStr + " " + op + " " + bStr + " = " + result);
        }

        return answer.toArray(new String[0]);
    }

    private boolean isPossibleBase(String[] expressions, int base) {
        for (String expression : expressions) {
            String[] parts = expression.split(" ");

            String aStr = parts[0];
            String op = parts[1];
            String bStr = parts[2];
            String cStr = parts[4];

            if (!isValidNumber(aStr, base) ||
                !isValidNumber(bStr, base)) {
                return false;
            }

            if (!cStr.equals("X") && !isValidNumber(cStr, base)) {
                return false;
            }

            if (!cStr.equals("X")) {
                int a = toDecimal(aStr, base);
                int b = toDecimal(bStr, base);
                int c = toDecimal(cStr, base);

                int value;

                if (op.equals("+")) {
                    value = a + b;
                } else {
                    value = a - b;
                }

                if (value != c) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidNumber(String str, int base) {
        for (char ch : str.toCharArray()) {
            int digit = ch - '0';

            if (digit >= base) {
                return false;
            }
        }

        return true;
    }

    private int toDecimal(String str, int base) {
        int value = 0;

        for (char ch : str.toCharArray()) {
            value = value * base + (ch - '0');
        }

        return value;
    }

    private String fromDecimal(int value, int base) {
        if (value == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (value > 0) {
            sb.append(value % base);
            value /= base;
        }

        return sb.reverse().toString();
    }
}