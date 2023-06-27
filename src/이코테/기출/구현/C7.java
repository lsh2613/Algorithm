package 이코테.기출.구현;

import java.util.Scanner;

public class C7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int left=0, right=0;
        for (int i = 0; i < input.length(); i++) {
            if (i <= input.length() / 2 - 1) { // 절반 기준 왼쪽
                left+=input.charAt(i)-'0';
            }
            else
                right+=input.charAt(i)-'0';
        }

        if (left == right)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
    }
}
