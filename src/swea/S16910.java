package swea;

import java.util.Scanner;
import java.util.stream.Stream;

public class S16910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int cnt = 0;

            int n = sc.nextInt();
            int square = n / 2 * 2;
            cnt += square * square;

            Integer set = Stream.iterate(1, i -> i + 4).limit(n / 2 + 1).reduce(0, (a, b) -> a + b);
            cnt += set * 4;
            System.out.println(cnt);

        }
    }
}
