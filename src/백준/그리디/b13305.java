package 백준.그리디;

import java.util.Scanner;

public class b13305 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] distances = new int[n - 1];
        int[] costs = new int[n];

        for (int i = 0; i < n - 1; i++) {
            distances[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }

        long minCost = costs[0];
        long sumCost = 0;
        for (int i = 0; i < distances.length; i++) {
            if (minCost>costs[i]) minCost=costs[i];
            sumCost += minCost * distances[i];
            // sumCost가 Long이어봤자 minCost와 distance가 int라 결과값이 int값이 들어감. 따라서 minCost를 long으로 바꿔줌
        }
        System.out.println(sumCost);

    }
}
