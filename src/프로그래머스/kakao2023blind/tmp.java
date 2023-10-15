import java.util.ArrayList;

class Solution {
    // 이모티콘 할인율 배열
    static int[] discounts = {10, 20, 30, 40};
    // 중복순열 결과 담을 임시 배열
    static int[] result = new int[7];
    // 이모티콘 총 경우의 수
    static int fin;
    // 이모티콘 별 모든 할인율 적용 케이스
    static ArrayList<int[]> res = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};
        // 유저 수
        int n = users.length;
        // 이모티콘 수
        int m = emoticons.length;

        // 이모티콘 총 경우의 수
        fin = (int) Math.pow(4, m);

        // result에 모든 경우의 수 중복 순열로 추가
        permutation_with_repetition(0, 4, m);

        // 모든 경우의 수에 따른 유저들의 최댓값 계산
        for (int i = 0; i < fin; i++) {
            int[] curr = res.get(i);
            int userNum = 0;
            int profitSum = 0;

            // 유저 별 케이스에서 구매액 계산
            for (int j = 0; j < n; j++) {
                int total = 0;

                for (int k = 0; k < curr.length; k++) {
                    // 구매 가능 비율이면 구매
                    if (users[j][0] <= curr[k]) {
                        total += emoticons[k] * (100 - curr[k]) / 100;
                    }

                    // 구매액을 넘겼으면 가입
                    if (users[j][1] <= total) {
                        total = 0;
                        userNum++;
                        break;
                    }
                }

                // 수입 추가
                profitSum += total;
            }

            // answer의 값과 비교하여 최댓값 추가
            if (answer[0] < userNum) {
                answer[0] = userNum;
                answer[1] = profitSum;
            } else if (answer[0] == userNum) {
                if (answer[1] < profitSum) {
                    answer[0] = userNum;
                    answer[1] = profitSum;
                }
            }
        }


        return answer;
    }

    private static void permutation_with_repetition(int cnt, int n, int r) {
        // r개를 선택했을 때 결과 배열에 지금까지 지나온 값들 저장
        if (cnt == r) {
            int[] tmp = result.clone();
            res.add(tmp);
            return;
        }
        // 중복순열이기 때문에 처음부터 탐색
        for (int i = 0; i < n; i++) {
            // 현재 cnt에 값 추가
            result[cnt] = discounts[i];
            // 이어서 재귀호출
            permutation_with_repetition(cnt + 1, n, r);
        }
    }
}
