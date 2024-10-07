package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    static int[] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 0;
        int right = houses[n - 1] + 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (putModem(mid) < c) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

    /**
     * @param len -> 공유기를 설치할 수 있는 최소거리
     * @return -> 몇 개를 설치할 수 있는지
     */
    static int putModem(int len) {
        int cnt = 1; // 맨 첫 집은 설치했다고 가정
        int lastPutIdx = houses[0]; // house를 정렬해놨기 때문에 최대 거리를 측정하기 위해선 맨 처음 집을 선택

        for (int i = 1; i < houses.length; i++) {
            // 마지막 설치한 위치부터 현재 놓으려는 집 houses간의 거리가 매개변수로 들어온 len의 최소거리보다 큰 경우에만 공유기 설치
            if (houses[i] - lastPutIdx >= len) {
                cnt++;
                lastPutIdx = houses[i];
            }
        }
        return cnt;
    }
}
