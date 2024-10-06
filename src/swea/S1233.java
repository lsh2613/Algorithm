package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class S1233
{
    static StringBuilder sb = new StringBuilder();
    static char[] nodes;
    static int n;


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            nodes = new char[n + 1];
            int answer = 1;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char val = st.nextToken().charAt(0);

                // 뒤에 값이 남아있다 -> 자식 노드 존재 -> 연산자여야 함
                if (st.hasMoreTokens()) {
                    if (Character.isDigit(val)) {
                        answer = 0;
                    }
                }
                else
                if (!Character.isDigit(val)) {
                    answer = 0;
                }

            }

            sb.append("#" + test_case + " "+answer+"\n");
        }
        System.out.println(sb);
    }
}
