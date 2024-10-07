package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14888_2 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int numCnt;
    static int nums[];
    static int ops[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numCnt = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        cal(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void cal(int cnt, int result) {
        if (cnt == numCnt) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                if (i == 0) {
                    cal(cnt + 1, result + nums[cnt]);
                } else if (i == 1) {
                    cal(cnt + 1, result - nums[cnt]);
                } else if (i == 2) {
                    cal(cnt + 1, result * nums[cnt]);
                } else if (i == 3) {
                    cal(cnt + 1, result / nums[cnt]);
                }
                ops[i]++;
            }
        }
    }
}
