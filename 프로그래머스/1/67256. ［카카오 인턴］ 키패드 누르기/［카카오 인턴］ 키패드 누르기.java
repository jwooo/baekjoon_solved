import java.util.*;

class Solution {
    
    String[][] keypads = {
        {"1", "2", "3"}, 
        {"4", "5", "6"}, 
        {"7", "8", "9"}, 
        {"*", "0", "#"}
    };
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answerBuilder = new StringBuilder();
        
        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        
        for (int i = 0; i < numbers.length; i++) {
            int[] index = findNumberIndex(numbers[i]);
            
            if (index[1] == 0) {
                left = index;
                answerBuilder.append("L");
            } else if (index[1] == 2) {
                right = index;
                answerBuilder.append("R");
            } else {
                int leftDistance = findDistance(left, index);
                int rightDistance = findDistance(right, index);
                
                if (leftDistance < rightDistance) {
                    left = index;
                    answerBuilder.append("L");
                } else if (rightDistance < leftDistance) {
                    right = index;
                    answerBuilder.append("R");
                } else {
                    if (hand.equals("left")) {
                        left = index;
                        answerBuilder.append("L");
                    } else {
                        right = index;
                        answerBuilder.append("R");
                    }
                }
            }
        }
        
        return answerBuilder.toString();
    }
    
    private int[] findNumberIndex(int number) {
        String n = String.valueOf(number);
        
        for (int i = 0; i < keypads.length; i++) {
            for (int j = 0; j < keypads[i].length; j++) {
                if (keypads[i][j].equals(n)) {
                    return new int[] {i, j};
                }
            }
        }
     
        return new int[] {-1, -1};
    }
    
    private int findDistance(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }
}