import java.util.*;

class Solution {

    int[] parent;
    String[] value;

    public String[] solution(String[] commands) {
        int size = 50 * 50;

        parent = new int[size];
        value = new String[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            value[i] = "";
        }

        List<String> answer = new ArrayList<>();

        for (String command : commands) {
            String[] split = command.split(" ");

            switch (split[0]) {
                case "UPDATE":
                    if (split.length == 4) {
                        int r = Integer.parseInt(split[1]) - 1;
                        int c = Integer.parseInt(split[2]) - 1;
                        String v = split[3];

                        int cell = index(r, c);
                        value[find(cell)] = v;

                    } else {
                        String oldValue = split[1];
                        String newValue = split[2];

                        for (int i = 0; i < size; i++) {
                            if (value[find(i)].equals(oldValue)) {
                                value[find(i)] = newValue;
                            }
                        }
                    }
                    break;

                case "MERGE":
                    int r1 = Integer.parseInt(split[1]) - 1;
                    int c1 = Integer.parseInt(split[2]) - 1;
                    int r2 = Integer.parseInt(split[3]) - 1;
                    int c2 = Integer.parseInt(split[4]) - 1;

                    int cell1 = index(r1, c1);
                    int cell2 = index(r2, c2);

                    union(cell1, cell2);
                    break;

                case "UNMERGE":
                    int r = Integer.parseInt(split[1]) - 1;
                    int c = Integer.parseInt(split[2]) - 1;

                    int cell = index(r, c);
                    unmerge(cell);
                    break;

                case "PRINT":
                    r = Integer.parseInt(split[1]) - 1;
                    c = Integer.parseInt(split[2]) - 1;

                    cell = index(r, c);
                    String result = value[find(cell)];

                    answer.add(result.isEmpty() ? "EMPTY" : result);
                    break;
            }
        }

        return answer.toArray(new String[0]);
    }

    private int index(int r, int c) {
        return r * 50 + c;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        String valueA = value[rootA];
        String valueB = value[rootB];

        String mergedValue;

        if (!valueA.isEmpty()) {
            mergedValue = valueA;
        } else {
            mergedValue = valueB;
        }

        parent[rootB] = rootA;
        value[rootA] = mergedValue;
        value[rootB] = "";
    }

    private void unmerge(int cell) {
        int root = find(cell);
        String originalValue = value[root];

        List<Integer> members = new ArrayList<>();

        for (int i = 0; i < parent.length; i++) {
            if (find(i) == root) {
                members.add(i);
            }
        }

        for (int member : members) {
            parent[member] = member;
            value[member] = "";
        }

        value[cell] = originalValue;
    }
}