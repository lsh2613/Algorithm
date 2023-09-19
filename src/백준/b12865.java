package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1]; // row 아이템으로 col 무게에 담을 수 있는 최대치
        int[] w = new int[n + 1]; // 무게
        int[] v = new int[n + 1]; // 가치

        for (int item = 1; item <= n; item++) {
            st = new StringTokenizer(br.readLine());
            w[item] = Integer.parseInt(st.nextToken());
            v[item] = Integer.parseInt(st.nextToken());

            for (int weight = 1; weight <= k; weight++) {
                //현재 아이템의 무게가 현재 수용할 수 있는 무게 j보다 큰 경우, 이전 상단값으로 값지정
                if (w[item] > weight)
                    dp[item][weight] = dp[item - 1][weight];

                    // (현재 아이템의 무게를 수용 + 남은 무게로 넣을 수 있는 최대치)와 이전 상단값과 비교
                else
                    dp[item][weight] = Math.max(dp[item - 1][weight], dp[item - 1][weight - w[item]] + v[item]);
            }
        }

        System.out.println(dp[n][k]);
    }
}
