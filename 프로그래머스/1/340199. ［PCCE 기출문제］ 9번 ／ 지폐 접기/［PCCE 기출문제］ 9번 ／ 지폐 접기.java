class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int length = bill[0];
        int width = bill[1];
        
        while (isSizeOfWallet(length, width, wallet)) {
            if (length > width) {
                length = length / 2;
            } else {
                width = width / 2;
            }
            
            answer++;
        }
        
        return answer;
    }
    
    boolean isSizeOfWallet(int length, int width, int[] wallet) {
        return (length > wallet[0] || width > wallet[1]) &&
            (length > wallet[1] || width > wallet[0]);
    }
}