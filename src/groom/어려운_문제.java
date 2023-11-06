package groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class 어려운_문제 {

    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger result = factorial(n);

        while (result.compareTo(BigInteger.valueOf(10)) >= 1) {
            result = BigInteger.valueOf(
                    Arrays.stream(result.toString().split(""))
                            .map(Integer::parseInt)
                            .reduce(0, (a, b) -> a + b)
            );
        }

        System.out.println(result.intValue());
    }
//    10 9 (8 7 6 5 4 3 2 1)
//            5 4 (3 2 1)
}
