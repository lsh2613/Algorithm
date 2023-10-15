package 프로그래머스.kakao2023blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//import java.util.ArrayList;
//
public class 이모티콘 {
    /*
    [[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]
    [1300, 1500, 1600, 4900]
    [4, 13860]

    [[40, 10000], [25, 10000]]
    [7000, 9000]
    [1, 5400]
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int users[][] = {
                {40, 10000}, {25, 10000}
        };
        int emotion[] = {7000, 9000};

        System.out.println(Arrays.toString(solution.solution(users, emotion)));
    }
}


class Solution {
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