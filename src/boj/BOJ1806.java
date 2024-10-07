package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1]; // 0~N-1 인덱스만 사용하지만 배열은 0~N까지 존재해야 함
        for (int i = 0; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        // 조건문 설명은 블로그 글 참고
        while (start <= end && end <= N) {
            if (sum < S) {
                sum += nums[end];
                end++;
            }
            if (sum >= S) {
                sum -= nums[start];
                start++;

                len = Math.min(len, end - start + 1);
            }
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
