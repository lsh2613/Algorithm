package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] LIS = new int[n];  // 0부터 i까지의 증가하는 길이
        int[] LDS = new int[n];   // i부터 맨끝까지 감소하는 길이

        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && LIS[j] + 1 > LIS[i]) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        for (int i = n-1; i >=0 ; i--) {
            LDS[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (nums[i] > nums[j] && LDS[j] + 1 > LDS[i]) {
                    LDS[i] = LDS[j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, LIS[i] + LDS[i] - 1);
        }

        System.out.println(result);
    }
}
