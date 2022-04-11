package SiliconValley_Dev_Matching;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int[] q1(int rows, int columns, int[][] connections, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int minRows = Math.min(query[0], query[2]);
            int maxRows = Math.max(query[0], query[2]);

            int minCols = Math.min(query[1], query[3]);
            int maxCols = Math.max(query[1], query[3]);

            //minRows 와 maxRows 안에 해당하며, minCols 와 maxCols 범위 안에 해당하면 연결끊X
            //
            for (int j = 0; j < connections.length; j++) {
                int[] connection = connections[j];
                int r1 = connection[0];
                int c1 = connection[1];
                int r2 = connection[2];
                int c2 = connection[3];

                if (r1 <= minRows && c1 <= minCols) {
//                    if (r2 > maxRows)
                }
                /*if (((minRows <= r1) && !(r2 <= maxRows) && (!(minCols <= c1) && c2 <= maxCols))) {
                    answer[i]++;
                } else if (!(minRows <= r1) && (r2 <= maxRows) && minCols <= c1 && !(c2 <= maxCols)) {
                    answer[i]++;
                }*/
            }
        }

        return answer;
    }

    public int[] q1(String[] names, int[][] homes, double[] grades) {
        List<Student> list = IntStream.range(0, names.length).mapToObj(i -> {
            int home = (homes[i][0] * homes[i][0]) + (homes[i][1] * homes[i][1]);
            Student student = new Student(i, names[i], home, (int) grades[i]);
            return student;
        }).sorted(Student::compareTo).collect(Collectors.toList());

        int[] answer = new int[names.length];
        for (int i = 0; i < list.size(); i++) {
            answer[list.get(i).getIndex()] = i + 1;
        }

        return answer;
    }
}

class Student implements Comparable<Student> {
    private int index;

    private String name;
    private int home;
    private int grade;

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getHome() {
        return home;
    }

    public int getGrade() {
        return grade;
    }

    public Student(int index, String name, int home, int grade) {
        this.index = index;
        this.name = name;
        this.home = home;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student s) {
        if (this.getGrade() < s.getGrade()) {
            return 1;
        } else if (this.getGrade() > s.getGrade()) return -1;
        else if (this.getHome() < s.getHome()) return 1;
        else if (this.getHome() > s.getHome()) return -1;

        return this.getName().compareTo(s.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", home=" + home +
                ", grade=" + grade +
                '}';
    }
}