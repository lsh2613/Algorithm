package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 개미_집합의_지름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        int left = 0, right = 0;
        int aliveAnt = 0;
        // left ~ rifgt 범위가 D를 만족하여 생존할 수 있는지 체크
        while (left <= right && left < N && right < N) {
//            if (left == right) { // 하나만 생존
//                aliveAnt = Math.max(aliveAnt, right - left + 1);
//                right++;
//            }
            int gap = nums[right] - nums[left];
            if (gap > D) { // D길이 이하를 만족해야 하므로 길이를 줄여야 됨 -> left++
                left++;
            }
            if (gap <= D) { // D이하를 만족하므로 다른 경우의 수를 찾기 위해 길으 늘림 -> right++
                aliveAnt = Math.max(aliveAnt, right - left + 1); // 조건 만족
                right++;
            }
        }
        System.out.println(N - aliveAnt);
    }
}
