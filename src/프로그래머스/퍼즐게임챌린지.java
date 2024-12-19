package 프로그래머스;

import java.util.Arrays;

public class 퍼즐게임챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        int maxValue = Arrays.stream(diffs).max().getAsInt();
        int minValue = 1;

        while (minValue < maxValue) {
            int level = (maxValue + minValue) / 2;
            long time = calTime(diffs, times, level);

            if (limit >= time) {
                maxValue = level;
            } else {
                minValue = level + 1;
            }
        }

        return minValue; // 또는 return maxValue;
    }

    private long calTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            int levelDiff = diffs[i] - level;

            if (levelDiff <= 0) {
                totalTime += times[i];
            } else {
                int prevTime = (i == 0 ? 0 : times[i - 1]);
                int curTime = times[i];
                int addTime = (prevTime + curTime) * levelDiff + curTime;

                totalTime += addTime;
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        퍼즐게임챌린지 puzzleGame = new 퍼즐게임챌린지();

        // 테스트 케이스 1
        int[] diffs1 = {1, 5, 3};
        int[] times1 = {2, 4, 7};
        long limit1 = 30;
        int result1 = puzzleGame.solution(diffs1, times1, limit1);
        System.out.println("테스트 케이스 1 결과: " + result1); // 예상 출력: 3

        // 테스트 케이스 2
        int[] diffs2 = {1, 4, 4, 2};
        int[] times2 = {6, 3, 8, 2};
        long limit2 = 59;
        int result2 = puzzleGame.solution(diffs2, times2, limit2);
        System.out.println("테스트 케이스 2 결과: " + result2); // 예상 출력: 2

        // 테스트 케이스 3
        int[] diffs3 = {1, 328, 467, 209, 54};
        int[] times3 = {2, 7, 1, 4, 3};
        long limit3 = 1723;
        int result3 = puzzleGame.solution(diffs3, times3, limit3);
        System.out.println("테스트 케이스 3 결과: " + result3); // 예상 출력: 294

        // 테스트 케이스 4
        int[] diffs4 = {1, 99999, 100000, 99995};
        int[] times4 = {9999, 9001, 9999, 9001};
        long limit4 = 3456789012L; // long 타입으로 명시
        int result4 = puzzleGame.solution(diffs4, times4, limit4);
        System.out.println("테스트 케이스 4 결과: " + result4); // 예상 출력: 39354
    }
}
