package 백준.그리디;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class b11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        while (n-- > 0) {
            arr[n] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = IntStream.range(0, arr.length)
                .map(i -> arr[i] * (arr.length - i))
                .sum();
        System.out.println(sum);
    }
}
