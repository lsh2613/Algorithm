package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1003 {
    static class pair {
        int zero; // fibo(0)이 호출된 횟수
        int one; // fibo(1)이 호출된 횟수

        public pair(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] input = br.lines().limit(n).mapToInt(Integer::parseInt).toArray();

        // 입력되는 수의 범위가 40까지 이므로
        pair[] dp = new pair[41];
        // 디폴트 값
        dp[0] = new pair(1, 0);
        dp[1] = new pair(0, 1);
        // i의 0과 1이 호출된 횟수는 i-1과 i-2에서 호출된 0의 합, 1의 합과 같다.
        for (int i = 2; i <= 40; i++) {
            pair prev1 = dp[i - 1];
            pair prev2 = dp[i - 2];
            dp[i] = new pair(prev1.zero + prev2.zero, prev1.one + prev2.one);
        }

        Arrays.stream(input).forEach(i -> System.out.println(dp[i].zero + " " + dp[i].one));

    }
}
