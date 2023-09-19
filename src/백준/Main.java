package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] woods = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int mid=0;
        long len = Arrays.stream(woods).map(x -> x - mid).filter(x -> x > 0).sum();
        long len2 = 0;
        for (int wood : woods) {
            if (wood - mid > 0) {
                len2 += wood - mid;
            }
        }

        System.out.println("len2 = " + len2);
        System.out.println("len = " + len);
    }
}