package 이코테.기출분석.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
    public static int findHeight(int[] arr, int target, int start, int end) {
        int max = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            sum=cutNoodle(arr,mid, target);
            // 요청한 떡의 길이보다 적을 경우 왼쪽 탐색(절단기 길이가 너무 긴 경우)
            if (sum < target) {
                end = mid - 1;
            }
            // 요청한 떡의 길이보다 크거나 같을 경우(절단기 길이가 적당한 경우)
            // 최댓값 갱신 후 오른쪽 탐색
            else {
                max = mid;
                start = mid + 1;
            }
        }
        return max;
    }
    static int cutNoodle(int[] arr, int h, int target) {
        return Arrays.stream(arr)
                .filter(x -> x > h)
                .map(x -> x - h)
                .sum();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findHeight(arr, m, 0, arr[n - 1]));
    }


}