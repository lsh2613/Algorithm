package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2156 {
    static int n;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n + 1];
        int[] maxDrink = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        maxDrink[1] = nums[1];
        if (n > 1) {
            maxDrink[2] = nums[1] + nums[2];
        }
        for (int i = 3; i <= n; i++) {
            maxDrink[i] = Math.max(maxDrink[i - 1], Math.max(maxDrink[i - 2] + nums[i], maxDrink[i - 3] + nums[i - 1] + nums[i]));

        }
        System.out.println(maxDrink[n]);
    }
}
