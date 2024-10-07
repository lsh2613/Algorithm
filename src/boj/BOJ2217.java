package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Integer[] lopes = new Integer[n];
        for (int i = 0; i < n; i++) {
            lopes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lopes, Collections.reverseOrder());
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lopes[i] * (i + 1));
        }
        System.out.println(max);
    }
}
