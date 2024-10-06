package 프로그래머스.kakao2023blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 이모티콘 {
    static int[] discounts = {10, 20, 30, 40};
    static List<int[]> permutations;
    static int[] permutation;

    public int[] solution(int[][] users, int[] emoticons) {
        int answer[] = {0, 0};
        permutations = new ArrayList<>();
        permutation = new int[emoticons.length];
        getPermutations(0, emoticons.length);

        // 완전 탐색
        for (int i = 0; i < permutations.size(); i++) {
            permutation = permutations.get(i);
            int subscribePlusCnt = 0;
            int sellPrice = 0;

            for (int j = 0; j < users.length; j++) {
                int total = 0;
                for (int k = 0; k < permutation.length; k++) {
                    if (users[j][0] <= permutation[k]) {
                        total += emoticons[k] * (100 - permutation[k]) / 100;
                    }

                    // 구매액을 넘겼으면 가입
                    if (users[j][1] <= total) {
                        total = 0; // 플러스 가입 시 이존에 구매했던 금액 초기화
                        subscribePlusCnt++;
                        break;
                    }
                }
                sellPrice += total;
            }

            if (answer[0] < subscribePlusCnt) {
                answer[0] = subscribePlusCnt;
                answer[1] = sellPrice;
            }
            if (answer[0] == subscribePlusCnt) {
                if (answer[1] < sellPrice) {
                    answer[0] = subscribePlusCnt;
                    answer[1] = sellPrice;
                }
            }
        }

        return answer;
    }

    static void getPermutations(int idx, int len) {
        if (idx == len) {
            permutations.add(permutation.clone());
            return;
        }

        for (int discount : discounts) {
            permutation[idx] = discount;
            getPermutations(idx + 1, len);
        }
    }
}
