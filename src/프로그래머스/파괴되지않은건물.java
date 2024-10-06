package 프로그래머스;

import java.util.Arrays;

public class 파괴되지않은건물 {

    static final int ATTACK = 1;
    static final int RECOVERY = 2;

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            for (int i = 0; i < skill.length; i++) {
                for (int j = skill[i][1]; j <= skill[i][3]; j++) {
                    for (int k = skill[i][2]; k <= skill[i][4]; k++) {
                        switch (skill[i][0]) {
                            case ATTACK:
                                board[j][k] -= skill[i][5];
                                break;
                            case RECOVERY:
                                board[j][k] += skill[i][5];
                        }
                    }
                }
            }

            long count = Arrays.stream(board)
                    .flatMapToInt(Arrays::stream)
                    .filter(value -> value >= 1)
                    .count();

            return (int) count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 첫 번째 테스트 케이스
        int[][] board1 = {
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5}
        };
        int[][] skill1 = {
                {1, 0, 0, 3, 4, 4},
                {1, 2, 0, 2, 3, 2},
                {2, 1, 0, 3, 1, 2},
                {1, 0, 1, 3, 3, 1}
        };
        int result1 = solution.solution(board1, skill1);
        System.out.println("첫 번째 테스트 결과: " + result1);  // 예상 결과: 10

        // 두 번째 테스트 케이스
        int[][] board2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] skill2 = {
                {1, 1, 1, 2, 2, 4},
                {1, 0, 0, 1, 1, 2},
                {2, 2, 0, 2, 0, 100}
        };
        int result2 = solution.solution(board2, skill2);
        System.out.println("두 번째 테스트 결과: " + result2);  // 예상 결과: 6
    }
}
