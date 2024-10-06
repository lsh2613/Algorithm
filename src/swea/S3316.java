package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S3316 {
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            char[] admins = br.readLine().toCharArray();
            int[][] dp = new int[10001][16];
            int result = 0;

            for (int day=0; day<admins.length; day++) {
                int admin = 1 << (admins[day] - 'A');
                for (int i=1; i<16; i++) {
                    //day가 0일 때 처음 열쇠는 A가 가지고 또한 활동의 책임자도 포함되어야 하므로
                    //A와 책임자가 모두 포함된 내용들을 dp[0][1~15]에 넣는다.
                    if (day == 0) {
                        if ((i & admin) != 0 && (i & 1) != 0) {
                            dp[day][i] = 1;
                        }
                    }
                    //이후 dp[1]부터는 이전 조건을 만족하는 동아리원(dp[0][1~15]중 0이아닌 배열)을 가져온 뒤
                    //다음 날의 조건을 충족하는지 계산한다. (admin은 해당 날짜의 책임자)
                    else if (dp[day-1][i] != 0) {
                        for (int j=1; j<16; j++) {
                            if ((i & j) != 0 && (j & admin) != 0) {
                                dp[day][j] += dp[day-1][i];
                                dp[day][j] %= 1000000007;
                            }
                        }
                    }
                }
            }

            for (int i=1; i<16; i++) {
                result += dp[admins.length-1][i];
                result %= 1000000007;
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
