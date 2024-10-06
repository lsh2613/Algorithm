package 프로그래머스;

import java.util.Arrays;

public class 사칙연산 {
    public static void main(String[] args) {

        System.out.println(new 사칙연산().solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
    }

    public int solution(String arr[]) {
        /**
         * 1. 순열/조합 -> 시간초과
         * 2. DP를 통한 이전 계산 값 유지
         *  i. 덧셈 -> 큰 값 끼리 합함 -> 최댓값
         *  ii. 뺄셈 -> 큰 값 - 작은 값 -> 최댓값
         * 따라서 작은 값을 찾기 위해 최솟값을 가지는 DP를 구현
         *
         * maxDp[i][j]: i번째 피연산자부터 j번쨰 피연산자까지 최댓값
         * minDp[i][j]: i번째 피연산자부터 j번쨰 피연산자까지 최솟값
         *
         * i, ii를 계산하기 위해
         * 덧셈 -> 최댓값 = 큰 값 + 큰 값
         *        최솟값 = 작은 값 + 작은 값
         * 뺄셈 -> 최댓값 = 큰 값 - 작은 값
         *        최솟값 = 작은 값 - 큰 값
         */

        int operandLen = arr.length / 2 + 1;
        int[][] min_dp = new int[operandLen][operandLen];
        int[][] max_dp = new int[operandLen][operandLen];

        Arrays.stream(min_dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        Arrays.stream(max_dp).forEach(row -> Arrays.fill(row, Integer.MIN_VALUE));

        for (int i = 0; i < operandLen; i++) {
            int value = Integer.parseInt(arr[i * 2]);
            min_dp[i][i] = value;
            max_dp[i][i] = value;
        }

        for (int step = 1; step < operandLen; step++) {
            for (int start = 0; start < operandLen - step; start++) {
                int end = step + start;
                for (int k = start; k < end; k++) {
                    int op = k * 2 + 1;
                    if (arr[op].equals("+")) {
                        max_dp[start][end] = Math.max(max_dp[start][end], max_dp[start][k] + max_dp[k + 1][end]);
                        min_dp[start][end] = Math.min(min_dp[start][end], min_dp[start][k] + min_dp[k + 1][end]);
                    } else if (arr[op].equals("-")) {
                        max_dp[start][end] = Math.max(max_dp[start][end], max_dp[start][k] - min_dp[k + 1][end]);
                        min_dp[start][end] = Math.min(min_dp[start][end], min_dp[start][k] - max_dp[k + 1][end]);
                    }
                }
            }
        }

        // 최종 결과 리턴 (예: 최대값)
        return max_dp[0][operandLen - 1];
    }
}
