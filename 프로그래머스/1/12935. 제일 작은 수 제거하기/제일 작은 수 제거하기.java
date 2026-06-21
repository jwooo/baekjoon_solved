class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        
        if (arr.length == 1) {
            answer = new int[] {-1};
        }
        
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) continue;
            answer[idx++] = arr[i]; 
        }
        
        return answer;
    }
}