package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> info = new HashMap<>();

        for (int w : weights) {
            answer += info.getOrDefault(w*1.0, 0) +
                    info.getOrDefault(w * 2.0, 0) +
                    info.getOrDefault(w / 2.0, 0) +
                    info.getOrDefault(w * 2 / 3.0, 0) +
                    info.getOrDefault(w * 3 / 2.0, 0) +
                    info.getOrDefault(w * 4 / 3.0, 0) +
                    info.getOrDefault(w * 3 / 4.0, 0);

            info.put(w*1.0, info.getOrDefault(w*1.0, 0) + 1);
        }

        return answer;
    }
}
