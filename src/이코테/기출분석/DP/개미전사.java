package 이코테.기출분석.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.*;

public class 개미전사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] storage = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int dp[] = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = storage[0];
        dp[1] = max(storage[0], storage[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2] + storage[i]);
        }
        System.out.println(dp[n - 1]);
    }
}
