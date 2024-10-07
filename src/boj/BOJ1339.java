package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] alphabets = new Integer[26];
        Arrays.fill(alphabets, 0);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int len = str.length();
            for (int j = 0; j < len; j++) {
                int pow = (int) Math.pow(10, len - j - 1);
                int idx = str.charAt(j) - 'A';
                alphabets[idx] += pow;
            }
        }

        Arrays.sort(alphabets, Comparator.reverseOrder());

        int result = 0;
        int order = 9;
        for (int i = 0; i < 10; i++) {
            result += order * alphabets[i];
            order--;
        }

        System.out.println(result);
    }
}
