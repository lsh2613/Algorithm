import com.sun.source.doctree.SummaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class 커플 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int negativeSum = 0;
        int positiveSum = 0;
        for (int num : nums) {
            if (num > 0) {
                positiveSum += num;
            } else {
                negativeSum += num;
            }
        }

        System.out.println(positiveSum+negativeSum);
    }
}