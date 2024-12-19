package 프로그래머스;

import java.util.Arrays;

/**
 * [시간초과 발생하는 풀이]
 * - level=1부터 순차적으로 time을 구하고, time<=limit이라면 return
 * - diff의 최대 길이 300,000
 * - level은 diffs의 최댓값만큼 가질 수 있으므로 최대 300,000
 * - 각 level마다 diff를 통한 time 구하기 = 300,000 * 300,000 = 9e^10(90억)
 *
 * [개선 방법 - 이분 탐색]
 * - 어차피 level은 diff의 최댓값까지 가질 수 있으므로 1<=level<=300,000
 * - 즉 level을 순차적으로 증가시키는 것이 아니라 '이분 탐색'을 통해 범위를 1/2씩 줄인다
 * - 따라서 이분 탐색의 시간 복잡도 O(log N)을 적용했을 때, level의 최대 횟수는 1<=level<=약 20
 * - 전체 시간 복잡도 = 300,000 * 20 = 6,000,000
 */
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
