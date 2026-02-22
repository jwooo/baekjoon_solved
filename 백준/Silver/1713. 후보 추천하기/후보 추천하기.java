import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        Set<Integer> candidates = new HashSet<>();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (candidates.contains(number)) {
                findStudent(number, students).ifPresent(s -> s.recommend++);
            } else {
                if (students.size() < n) {
                    students.add(new Student(number, 1, i));
                    candidates.add(number);
                } else {
                    Student lastStudent = students.get(students.size() - 1);

                    candidates.remove(lastStudent.number);
                    students.remove(lastStudent);

                    candidates.add(number);
                    students.add(new Student(number, 1, i));
                }
            }

            Collections.sort(students);
        }

        String result = students.stream()
                .map(s -> s.number)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    private Optional<Student> findStudent(int number, List<Student> students) {
        return students.stream()
                .filter(i -> i.number == number)
                .findFirst();
    }

    static class Student implements Comparable<Student> {
        int number;
        int recommend;
        int postTime;

        public Student(int number, int recommend, int postTime) {
            this.number = number;
            this.recommend = recommend;
            this.postTime = postTime;
        }

        @Override
        public int compareTo(Student o) {
            if (this.recommend == o.recommend) {
                return o.postTime - this.postTime;
            }

            return o.recommend - this.recommend;
        }

    }

}