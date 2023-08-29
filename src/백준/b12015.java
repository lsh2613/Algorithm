package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] LIS = new int[n];

        // 첫 번째 값을 넣어 두고 시작
        LIS[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            // lis의 마지막 값보다 nums의 값이 더 크다면 lis 마지막에 추가
            if (LIS[len - 1] < nums[i]) {
                LIS[len] = nums[i];
                len++;
            }
            // nums보다 큰 값 중 가장 왼쪽을 찾아 교체
            else {
                int left = 0;
                int right = len;
                int findNum = nums[i];

                // under bound 이분 탐색 진행,
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (findNum > LIS[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                LIS[left] = findNum;
            }
        }

        System.out.println(len);

    }
}
