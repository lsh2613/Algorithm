package 이코테.기출분석.정렬;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class 성적이낮은수서로학생출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Student> students = new ArrayList();
        while (n-- > 0) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        students.forEach(i -> System.out.println(i.getName()+" "));
    }
}
