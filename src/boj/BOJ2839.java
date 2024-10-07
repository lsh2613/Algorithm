package boj;

import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        /**
         * 당연히 5의배수는 5kg으로만 채워야 최소가 됨.
         * 그렇다면 5의배수 +1은? ex) 16은 15+1이다. 15에서 5키로를 빼고 6으로 바꾼다 생각하자. 그럼 16=10+6이다.
         * 즉 5의 배수+1은 5의배수였을 때의 봉지 개수 + 1개를 한 것과 같다.
         * 이러한 규칙을 표에 작성해보자
         * https://st-lab.tistory.com/72
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(bagCount(n));
    }

    private static int bagCount(int n) {
        if (n == 4 || n == 7) {
            return -1;
        }
        else if (n % 5 == 0) {
            return (n / 5);
        }
        else if (n % 5 == 1 || n % 5 == 3) {
            return (n / 5) + 1;
        }
        else if (n % 5 == 2 || n % 5 == 4) {
            return (n / 5) + 2;
        }
        return -1;
    }
}
