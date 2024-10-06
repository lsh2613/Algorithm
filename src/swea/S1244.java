package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class S1244
{
    static int[] nums;
    static int max;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            nums = str.chars().map(c -> c - '0').toArray();
            int cnt = Integer.parseInt(st.nextToken());
            int len = str.length();

            // 자릿수 보다 교환횟수가 더 큰 경우 불필요한 연산이 수행
            // 자릿수 만큼의 교환만 일어나면 되므로 횟수를 줄여준다
            if(cnt>len) {
                cnt = len;
            }

            max = 0; // 새로운 테스트 케이스에 대해 max=0 부터 시작
            dfs(0, 0, cnt);
            System.out.printf("#%d %d\n", test_case, max);
        }
    }

    static void dfs(int start, int cur, int cnt) {

        if (cur == cnt) { // 교환 횟수와 동일하다면 dfs 종료
            StringBuilder sb = new StringBuilder();
            Arrays.stream(nums).forEach(i -> sb.append(i));
            int num = Integer.parseInt(sb.toString());
            max = Math.max(max, num); // 완전 탐색을 통해 교환된 모든 경우의 수 중 가장 큰 값을 찾기 위함
            return;
        }
        else { // 완전 탐색
            for (int i = start; i < nums.length-1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    swap(i, j);
                    dfs(i, cur + 1, cnt);
                    swap(i, j); // dfs로 던져놓고 다음 과정을 위해 다시 되돌림
                }
            }
        }
    }
    static void swap(int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
