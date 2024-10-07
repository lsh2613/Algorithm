package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int [][] rank;
        while(tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            rank = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                rank[i][0] = Integer.parseInt(st.nextToken());
                rank[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(rank, Comparator.comparingInt(a -> a[0]));
            int cnt = 0;
            int maxPrior = rank[0][1]; // 최대 순위를 저장하므로, 값이 낮을 수록 순위가 높다
            for (int i = 0; i < n; i++) {
                if (rank[i][1] <= maxPrior) { // =는 가장 첫번째 최대값이 0번인덱스로 첫 사람을 포함해주기 위해
                    maxPrior = rank[i][1];
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}
