package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][];

        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < nums[i].length; j++) {
                int maxChild = Math.max(nums[i + 1][j], nums[i + 1][j + 1]);
                nums[i][j] += maxChild;
            }
        }

        System.out.println(nums[0][0]);
    }
}
