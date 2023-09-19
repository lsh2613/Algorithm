package swEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 수열편집
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#" + test_case + " ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

//            List<String> l = Arrays.stream(br.readLine().split(" ")).toList();
//            LinkedList<String> list = new LinkedList<>(l);
            String[] str = br.readLine().split(" ");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(str));

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int to;
                String val;
                switch (command) {
                    case "I":
                        to = Integer.parseInt(st.nextToken());
                        val = st.nextToken();
                        list.add(to, val);
                        break;
                    case "D":
                        to = Integer.parseInt(st.nextToken());
                        list.remove(to);
                        break;
                    case "C":
                        to = Integer.parseInt(st.nextToken());
                        val = st.nextToken();
                        list.remove(to);
                        list.add(to, val);
                }
            }
            if (L < 0 || L >= list.size())
                sb.append("-1\n");
            else
                sb.append(list.get(L) + "\n");
        }
        System.out.println(sb);
    }

}