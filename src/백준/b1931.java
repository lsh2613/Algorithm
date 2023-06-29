package 백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class b1931 {
    /**
     * 종료시간이 빠른순으로 수업이 겹치지 않게 고른다.
     * 따라서 종료시간으로 오름차순 정렬하여 앞에서부터 고르는데, 이때 같은 종료시간 중 시작시간이 더 빠른 것을 선택해야 하므로
     * 종료시간이 같을 경우에는 시작시간이 빠른 순으로 즉 오름차순으로 정렬해야 한다.
     */
    static final int startTime = 0;
    static final int endTime = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int tt[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            tt[i][startTime] = sc.nextInt();
            tt[i][endTime] = sc.nextInt();
        }

        Arrays.sort(tt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[endTime]==o2[endTime])
                    return o1[startTime] - o2[startTime];
                return o1[endTime] - o2[endTime];
            }
        });

        int prevEndTime = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (prevEndTime <= tt[i][startTime]) {
                prevEndTime = tt[i][endTime];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
