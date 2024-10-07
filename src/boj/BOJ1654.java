package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        long low = 0;
        long high = (long) Arrays.stream(nums).max().getAsInt() + 1;
        long mid = 0;

        // 이분 탐색 시작
        while (low < high) {
            mid = (low + high) / 2;
            int wireCnt = 0;
            for (int i = 0; i < nums.length; i++) {
                wireCnt += (nums[i] / mid);
            }

            if (n <= wireCnt) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        System.out.println(low - 1);
    }
}
