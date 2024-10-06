package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b14890 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (canGo(i, 0, true))
                cnt++;
            if (canGo(0, i, false))
                cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean canGo(int r, int c, boolean isRow) {
        int[] height = new int[N];
        boolean[] ramp = new boolean[N];

        for (int i = 0; i < N; i++) {
            height[i] = isRow ? map[r][c + i] : map[r + i][c];
        }

        for (int i = 0; i < N - 1; i++) {
            int heightDiff = height[i] - height[i + 1];

            //높이차이 2이상 -> 경사로 놓아도 못지나감
            if (Math.abs(heightDiff) >= 2)
                return false;
            // 높이차이 0 -> 그냥 지나감
            if (heightDiff == 0)
                continue;

            if (heightDiff == 1) { // 내리막
                for (int j = i + 1; j <= i + L; j++) {
                    if (outOfMap(j) || height[i + 1] != height[j] || ramp[j])
                        return false;
                    ramp[j] = true;
                }
                i += L - 1;
            } else if (heightDiff == -1) { // 오르막
                for (int j = i; j > i - L; j--) {
                    if (outOfMap(j) || height[i] != height[j] || ramp[j])
                        return false;
                    ramp[j] = true;
                }
            }
        }
        return true;
    }

    public static boolean outOfMap(int x) {
        return 0 > x || x >= N;
    }
}
