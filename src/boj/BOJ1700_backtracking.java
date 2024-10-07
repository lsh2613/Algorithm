package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ1700_backtracking {
    static int N;
    static int K;
    static int[] nums;
    static int[] plugs;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        plugs = new int[N];
        nums = Arrays.stream(br.readLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        if (N>=K) {
            System.out.println(0);
            return;
        }

        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int now, int unplug) {
        if (now == K) {
            min = Math.min(min, unplug);
            return;
        }

        boolean isInArray = Arrays.stream(plugs).anyMatch(n -> n == nums[now]);

        // 1. 이미 꽂혀있으면 넘어감
        if (isInArray) {
            dfs(now + 1, unplug);
            return;
        }

        // 2. 비어있는 곳 있으면 unplug 안 하고 비어 있는 곳 사용
        OptionalInt optionalEmptyPlug = IntStream.range(0, plugs.length)
                .filter(i -> plugs[i] == 0)
                .findFirst();
        if (optionalEmptyPlug.isPresent()) {
            int emptyPlug = optionalEmptyPlug.getAsInt();
            plugs[emptyPlug] =nums[now];
            dfs(now + 1, unplug);
            return;
        }

        // 3. unplug 해야 한다면 plug를 백트래킹
        for (int i = 0; i < N; i++) {
            int before = plugs[i];
            plugs[i] = nums[now];
            dfs(now + 1, unplug + 1);
            plugs[i] = before;
        }
    }
}
