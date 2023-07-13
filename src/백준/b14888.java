package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b14888 {

    public static int n;
    public static int[] nums;
    public static int plus, minus, mul, div;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    // dfs를 통한 완전탐색
    public static void dfs(int i, int result) {
        // 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
        if (i == n) {
            min = Math.min(min, result);
            max = Math.max(max, result);
        }
        else {
            // 각 연산자에 대하여 재귀적으로 수행
            if (plus > 0) {
                plus -= 1;
                dfs(i + 1, result + nums[i]);
                plus += 1;
            }
            if (minus > 0) {
                minus -= 1;
                dfs(i + 1, result - nums[i]);
                minus += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(i + 1, result * nums[i]);
                mul += 1;
            }
            if (div > 0) {
                div -= 1;
                dfs(i + 1, result / nums[i]);
                div += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());

        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        // 첫 번째 숫자를 시작으로 dfs 완전탐색 실행
        dfs(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }
}