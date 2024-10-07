package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
    static int[] ancestor;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // init
        ancestor = new int[N+1];
        for (int i = 1; i <= N; i++) {
            ancestor[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            switch (op) {
                case 0:
                    union(from, to);
                    break;
                case 1:
                    boolean unionFlag = unionCheck(from, to);
                    if (unionFlag) {
                        sb.append("YES\n");
                        break;
                    }
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        int aAncestor = findAncestor(a);
        int bAncestor = findAncestor(b);

        // 루트 노드는 작은 값으로 지정
        if (aAncestor > bAncestor)
            ancestor[aAncestor] = bAncestor;
        if (aAncestor < bAncestor)
            ancestor[bAncestor] = aAncestor;

    }
    static boolean unionCheck(int a, int b) {
        int aAncestor = findAncestor(a);
        int bAncestor = findAncestor(b);

        if (aAncestor == bAncestor) // 같은 집합
            return true;

        return false;
    }

    static int findAncestor(int n) {
        if (n != ancestor[n]) {  // 루트 노드가 아니라면
            ancestor[n] = findAncestor(ancestor[n]);
        }
        return ancestor[n];
    }
}
