package groom;

import javax.swing.text.AttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

class 계수기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int digits = Integer.parseInt(br.readLine());

        int[] maxOfDigits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int click = Integer.parseInt(br.readLine());

        int[] valueOfDigits = new int[digits];
        valueOfDigits[digits - 1] = 1;
        for (int i = digits - 2; i >= 0; i--) {
            valueOfDigits[i] = (maxOfDigits[i + 1] + 1) * valueOfDigits[i + 1];
        }

        long valueOfNum = 0;
        for (int i = 0; i < num.length; i++) {
            valueOfNum += valueOfDigits[i] * num[i];
        }
        valueOfNum += click;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < valueOfDigits.length; i++) {
            if (i == 0 && (int) (valueOfNum / valueOfDigits[i]) > maxOfDigits[i]) {
                result.add(0);
            }
            else
                result.add((int)(valueOfNum / valueOfDigits[i]));
            valueOfNum %= valueOfDigits[i];
        }
        System.out.println(
                result.stream()
                .map(Objects::toString)
                .reduce("", (a, b) -> a + b)
        );
    }
}