package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Set<Integer> consent = new HashSet<>();

        int unplug = 0;
        for (int cur = 0; cur < K; cur++) {
            int num = nums.get(cur);

            // 1. 이미 꽂혀있으면 넘어감
            if (consent.contains(num))
                continue;

            // 2. 비어있는 곳 있으면 unplug 안 하고 비어 있는 곳 사용
            if (consent.size() < N) {
                consent.add(num);
                continue;
            }

            /**
             * 3. 가장 나중에 사용되는 전기용품을 뺀다
             *  ex) plug_01, plug_02가 있을 때
             *  3.1 01, 02가 모두 미래에 사용된다면 가장 나중에 사용되는 plug를 unplug
             *  3.2 둘 중 하나만 미래에 사용된다면 사용되지 않는 plug를 unplug
             */
            int idx = -1;
            int latestPoint = -1;
            for (Integer plug : consent) {
                int usePoint = 0;
                List<Integer> sub = nums.subList(cur + 1, K);
                if (sub.contains(plug)) {
                    usePoint = sub.indexOf(plug);
                }
                else // 3.2를 성립시키기 위해
                    usePoint = Integer.MAX_VALUE;

                if (usePoint > latestPoint) {
                    latestPoint = usePoint;
                    idx = plug;
                }
            }

            consent.remove(idx);
            consent.add(num);
            unplug++;
        }

        System.out.println(unplug);
    }
}
