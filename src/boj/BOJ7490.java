package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ7490 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int number;

        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(br.readLine());
            dfs(number, 1, 1, 1, 0, "1");
            System.out.println();
        }
    }

    static void dfs(int max, int now, int num, int sign, int sum, String str) {
        if (max == now) {
            sum = sum + (num * sign);
            if (sum == 0) {
                System.out.println(str);
            }
            return;
        }
        // 빈칸 처리
        dfs(max, now + 1, num * 10 + (now + 1), sign, sum, str + " " + (now + 1));
        // '+' 처리
        dfs(max, now + 1, now + 1, 1, sum + (num * sign), str + "+" + (now + 1));
        // '-' 처리
        dfs(max, now + 1, now + 1, -1, sum + (num * sign), str + "-" + (now + 1));
    }
}
