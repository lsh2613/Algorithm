package boj;

import java.util.Scanner;

public class BOJ7568 {
    static class person {
        int h;
        int w;
        int rank = 1;
        public person(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        person[] people = new person[n];

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            people[i] = new person(h, w);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (people[i].h < people[j].h && people[i].w < people[j].w) {
                    people[i].rank++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf(people[i].rank + " ");
        }



    }
}
