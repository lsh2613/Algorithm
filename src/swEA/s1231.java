package swEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1231
{
    static StringBuilder sb;
    static char[] nodes;
    static int n;

    static void inOrder(int cur) {
        if (cur>n) return;
        inOrder(cur * 2);
        sb.append(nodes[cur]);
        inOrder(cur * 2+1);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sb = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            nodes = new char[n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char val = st.nextToken().charAt(0);
                nodes[idx] = val;
            }
            sb.append("#" + test_case + " ");
            inOrder(1);
            sb.append("\n");
            System.out.println(sb);
        }
    }
}