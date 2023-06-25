package 백준.그리디;

import java.util.Scanner;

public class b1541 {
    public static void main(String[] args) {
        /**
         * +를 먼저 계산하면 됨
         */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] minusSubstring = str.split("-");
        int result = 0;
        for (int i = 0; i < minusSubstring.length; i++) {
            int tmp = 0;
            String[] plusSubstring = minusSubstring[i].split("\\+");
            for (int j = 0; j < plusSubstring.length; j++) {
                tmp+=Integer.parseInt(plusSubstring[j]);
            }
            if (i==0)
                result += tmp;
            else
                result -= tmp;
        }
        System.out.println(result);

    }
}
