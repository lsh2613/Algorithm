package 기출.그리디;

import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char c = str.charAt(0);
        int cnt = 0; // 값이 0->1 혹은 1->0으로 바뀌는 횟수
        for (int i = 1; i < str.length(); i++) {
            if (c != str.charAt(i)) {
                cnt++;
                c = str.charAt(i);
            }
        }
        System.out.println((cnt+1)/2);

    }
}
