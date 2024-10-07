package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] accumulatedSum = new int[n];
        //누적합 계산
        accumulatedSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            accumulatedSum[i] = accumulatedSum[i - 1] + nums[i];
        }

        answer = Math.max(answer, accumulatedSum[m-1]);
        for (int i = m; i < n; i++) {
            answer = Math.max(answer, accumulatedSum[i] - accumulatedSum[i - m]);
        }

        System.out.println(answer);
    }
}
