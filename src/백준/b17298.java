package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class b17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                output[s.pop()] = nums[i];
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            output[s.pop()] = -1;
        }


        Arrays.stream(output).forEach(x -> System.out.print(x + " "));

//        for (int i = 0; i < n; i++) {
//            System.out.print(output[i] + " ");
//        }

//        Arrays.stream(output).forEach(x -> sb.append(x+" "));
//        System.out.println(sb);

    }
}
