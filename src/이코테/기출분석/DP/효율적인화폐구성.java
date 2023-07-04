package 이코테.기출분석.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = br.lines().limit(n).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[k+1];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) { // 화폐 갯수 만큼
            for (int j = coins[i]; j <= k; j++) { // 목표 금액까지의 dp 할당
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}
