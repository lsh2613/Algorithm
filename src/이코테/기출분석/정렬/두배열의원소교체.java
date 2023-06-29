package 이코테.기출분석.정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 두배열의원소교체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[n];
        Integer[] B = new Integer[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            if (A[i] < B[i]) {
                int tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
            }
        }
        System.out.println(Arrays.stream(A).sum());
    }
}
