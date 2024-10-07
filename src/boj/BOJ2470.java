package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        Arrays.sort(nums);

        int left = 0, right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                result[0] = nums[left];
                result[1] = nums[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
