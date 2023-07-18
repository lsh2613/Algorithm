package swEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s10726 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int fullBits = (1 << n) - 1;
            if ((m & fullBits) == fullBits) {
                sb.append("#" + test_case + " ON\n");
            } else {
                sb.append("#" + test_case + " OFF\n");
            }
        }
        System.out.println(sb);
    }
}
