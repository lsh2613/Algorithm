package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15650 {
    static StringBuilder sb = new StringBuilder();
    static int k;
    static StringBuilder nums = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            nums.append(i);
        }
        dfs("", nums.toString());

        System.out.println(sb.toString());
    }

    static void dfs(String now, String remain) {
        if (now.length()==k) sb.append(String.join(" ", now.split("")) + "\n");

        for (int i = 0; i < remain.length(); i++) {
            if (now.length()==0 || now.length()>=1 && now.charAt(now.length() - 1) < remain.charAt(i))
                dfs(now + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1));
        }
    }
}
