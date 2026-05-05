import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Row row = new Row(data[i][0], data[i][1], data[i][2], data[i][3]);
            
            if (row.isMatching(ext, val_ext)) {
                rows.add(row);
            }
        }
        
        if (sort_by.equals("code")) {
            Collections.sort(rows, (i, j) -> i.code - j.code);
        } else if (sort_by.equals("date")) {
            Collections.sort(rows, (i, j) -> i.date - j.date);
        } else if (sort_by.equals("maximum")) {
            Collections.sort(rows, (i, j) -> i.maximum - j.maximum);
        } else {
            Collections.sort(rows, (i, j) -> i.remain - j.remain);
        }
        
        int[][] answer = new int[rows.size()][4];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = rows.get(i).getData();
        }
        
        return answer;
    }
 
    static class Row {
        int code;
        int date;
        int maximum;
        int remain;
        
        public Row(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        
        public boolean isMatching(String ext, int value) {
            if (ext.equals("code")) {
                return this.code < value;
            } else if (ext.equals("date")) {
                return this.date < value;
            } else if (ext.equals("maximum")) {
                return this.maximum < value;
            } else {
                return this.remain < value;
            }
        }
        
        public int[] getData() {
            return new int[] {code, date, maximum, remain};
        }
    }
}