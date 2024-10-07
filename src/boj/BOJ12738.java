package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> result = new ArrayList<>();
        result.add(Integer.MIN_VALUE);

        for (int num : nums) {
            if (result.get(result.size() - 1) < num) {
                result.add(num);
            }
            else {
                int left = 0;
                int right = result.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (result.get(mid) < num) {
                        left = mid + 1;
                    }
                    else {
                        right = mid;
                    }
                }
                result.set(right, num);
            }
        }

        System.out.println(result.size() - 1);
    }
}
