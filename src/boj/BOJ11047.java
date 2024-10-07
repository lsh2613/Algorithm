package boj;

import java.util.Scanner;

public class BOJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int cnt = 0; // 필요한 동전 갯수
        for (int i = coins.length-1; i >= 0; i--) {
            int num = k / coins[i];
            cnt += num;
            k -= num * coins[i];
            if (k==0) break;

        }
        System.out.println(cnt);

    }
}
