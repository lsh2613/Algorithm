import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 민석이의마니또.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class S17299
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            // int -> int[]
            int[] num = str.chars().map(c -> c - '0').toArray();
            int len = num.length;
            int half = len / 2;

            int[] subLeft = Arrays.copyOf(num, half);
            int[] subRight = Arrays.copyOfRange(num, half, num.length);
            int sumLeft = sum(subLeft);
            int sumRight = sum(subRight);

            if (num.length % 2 == 0) { //짝수면 무조건 반갈
                System.out.printf("#%d %d\n", test_case, sumLeft + sumRight);
            }
            else { // 홀수일 땐 왼쪽이 긴 배열, 오른쪽이 긴 배열 두 경우가 있으므로
                int[] subLeft2 = Arrays.copyOf(num, half + 1);
                int[] subRight2 = Arrays.copyOfRange(num, half + 1, num.length);
                int sumLeft2 = sum(subLeft2);
                int sumRight2 = sum(subRight2);

                System.out.printf("#%d %d\n", test_case, min(sumLeft + sumRight, sumLeft2 + sumRight2));
            }

        }
    }

    static int sum(int[] arr) {
        int cnt = 1;
        int result = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            result = result + arr[i] * cnt;
            cnt *= 10;
        }
        return result;
    }
}
