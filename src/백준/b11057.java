package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        // 초기값
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = Arrays.stream(dp[i - 1]).reduce(0, (a, b) -> (a + b) % 10007);
                } else {
                    for (int k = j; k < 10; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= 10007;
                    }
                }
            }
        }

        System.out.println(Arrays.stream(dp[n]).sum() % 10007);
    }
}
