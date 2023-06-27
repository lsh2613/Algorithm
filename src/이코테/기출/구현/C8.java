package 이코테.기출.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Character> alphabets = new ArrayList<>();
        ArrayList<Character> digits = new ArrayList();

        String input = sc.next();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                digits.add(c);
            } else alphabets.add(c);
        }
        Collections.sort(alphabets);
        Collections.sort(digits);

        for (int i = 0; i < alphabets.size(); i++) {
            System.out.print(alphabets.get(i));
        }
        for (int i = 0; i < digits.size(); i++) {
            System.out.print(digits.get(i));
        }
        // 어차피 아스키코드상 문자<숫자라 리스트 2개 만들 필요없이 한 번에 정렬해도 됨
    }
}
