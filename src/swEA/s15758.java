package swEA;

import java.util.Scanner;

class s15758
{
    public static long lcm(long a, long b) {
        int gcd_value = gcd((int)a, (int)b);

        if (gcd_value == 0) return 0; // 인수가 둘다 0일 때의 에러 처리

        return Math.abs( (a * b) / gcd_value );
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            int len1 = str1.length();
            int len2 = str2.length();
            long lcm = lcm(len1, len2);
            String result1 = "";
            String result2 = "";
            for (int i = 0; lcm != i * len1; i++) {
                result1 += str1;
            }
            for (int i = 0; lcm != i * len2; i++) {
                result2 += str2;
            }
            System.out.printf("#%d ",test_case);
            System.out.println(result1.equals(result2) ? "yes" : "no");
        }
    }
}