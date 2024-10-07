package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] accumulateSum = new int[n];
        // 누적합 계산
        accumulateSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            accumulateSum[i] = accumulateSum[i - 1] + nums[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // n번째가 아닌 n인덱스를 구하기 위해 -1
            int x = Integer.parseInt(st.nextToken()) - 1 - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if (x<=-1)
                sb.append(accumulateSum[y] + "\n");
            else
                sb.append(accumulateSum[y] - accumulateSum[x] + "\n");
        }

        System.out.println(sb.toString());
    }
}
