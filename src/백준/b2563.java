package 백준;

import java.util.Scanner;

public class b2563 {

    static boolean[][] overlap = new boolean[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    overlap[j][k] = true;
                }
            }
        }
        for (boolean bs[] : overlap) {
            for (boolean b : bs) {
                if (b)
                    cnt++;
            }
        }
        System.out.println(cnt);


    }
}
