package 기출.그리디;

import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int result = str.charAt(0)-'0';
        for (int i = 1; i < str.length(); i++) {
            int intOfStr = str.charAt(i)-'0';
            if (result <= 1 || intOfStr <= 1) {
                result += intOfStr;
            } else result *= intOfStr;
        }
        System.out.println(result);
    }
}
