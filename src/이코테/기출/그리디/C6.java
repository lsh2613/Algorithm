package 이코테.기출.그리디;

import java.util.Scanner;

class Solution {
    public static int solution(int[] food_times, long k) {
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        int i;
        for (i = 0; k!=0; i++) {
            if (food_times[i%food_times.length]!=0){    // 다 먹은 음식은 건너뜀
                food_times[i%food_times.length]--;     // i를 순환시켜 마지막 접시 다음은 첫 음식을 섭취
                k--;
            }
        }
        // k가 줄어들어 0이되면 i가 증가되고 반복문을 탈출하기에 다음 음식의 값을 i가 갖고있다.
        // i부터 시작해서 다음 접시 중 가장 가까운 번호의 음식을 출력
        int answer=0;
        for (; food_times[i% food_times.length]==0; i++) {
            i=answer;
        }
        return answer+1;
    }
}
public class C6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int food_times[] = {3, 1, 2};
        int k = 5;
        System.out.println(Solution.solution(food_times, k));
    }
}
