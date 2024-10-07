package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BOJ17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> numCnt = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            // 순차탐색하고 있는 값의 등장횟수가 스택에 담긴 idx의 값의 등장횟수보다 크다면
            while (!s.isEmpty() && numCnt.get(nums[s.peek()]) < numCnt.get(nums[i])) {
                result[s.pop()] = nums[i];
            }
            s.push(i);
        }

        // 스택에 남아있다는 것은 오등큰수에 해당 X -> 전부 -1로
        while (!s.isEmpty()) {
            result[s.pop()] = -1;
        }

        Arrays.stream(result).forEach(x -> sb.append(x + " "));
        System.out.println(sb);
    }
}
