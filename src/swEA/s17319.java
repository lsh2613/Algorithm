package swEA;

import java.util.Scanner;
class s17319
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int len = sc.nextInt();
            String str = sc.next();
            if (len == 1) {
                sb.append("#" + test_case + " No\n");
                continue;
            }
            String sub1 = str.substring(0, len/2);
            String sub2 = str.substring(len/2);
            if (sub1.equals(sub2)) {
                sb.append("#" + test_case + " Yes\n");
            } else sb.append("#" + test_case + " No\n");
        }
        System.out.println(sb);
    }
}