import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            fileList.add(new File(files[i]));
        }
        
        fileList.sort((file1, file2) -> {
           	int headComparator = file1.head.compareTo(file2.head);
            
            if (headComparator != 0) return headComparator;
            return file1.number - file2.number;
        });
        
        String[] answer = new String[files.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fileList.get(i).fileName;
        }
        
        return answer;
    }
    
    static class File {
        String fileName;
        String head;
        int number;
        
        public File(String fileName) {
            this.fileName = fileName;
            parse();
        }
        
        private void parse() {
            int len = fileName.length();
            int i = 0;
            
            StringBuilder headBuilder = new StringBuilder();
            while (i < len && !Character.isDigit(fileName.charAt(i))) {
                headBuilder.append(fileName.charAt(i));
                i++;
            }
            
            this.head = headBuilder.toString().toLowerCase();
            
            StringBuilder numberBuilder = new StringBuilder();
            int count = 0;
            while (i < len && Character.isDigit(fileName.charAt(i)) && count < 5) {
                numberBuilder.append(fileName.charAt(i));
                i++;
                count++;
            }
            
            this.number = Integer.parseInt(numberBuilder.toString());
        }
    }
}