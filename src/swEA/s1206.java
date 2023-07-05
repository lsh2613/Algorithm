package swEA;

import java.io.IOException;
import java.util.Scanner;

public class s1206 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] buildings;
        int N;
        int[] dir = new int[]{1, 2, -2, -1};

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // 가로 길이
            buildings = new int[N];
            for (int i = 0; i < N; i++) {
                buildings[i] = sc.nextInt();
            }

            int sum = 0;

            int cnt = 0;
            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(buildings[i - 2], Math.max(buildings[i - 1], Math.max(buildings[i + 1], buildings[i + 2])));
                if (buildings[i] - max > 0)
                    cnt += buildings[i] - max;
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}
