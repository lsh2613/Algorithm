package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b20040 {
    static int[] ancestor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // init
        ancestor = new int[N];
        for (int i = 0; i < N; i++) {
            ancestor[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (!union(from, to)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    static boolean union(int a, int b) {
        int aAncestor = findAncestor(a);
        int bAncestor = findAncestor(b);

        if (aAncestor == bAncestor) // 같으면 순환
            return false;
        // 루트 노드는 작은 값으로 지정
        if (aAncestor > bAncestor)
            ancestor[aAncestor] = bAncestor;
        if (aAncestor < bAncestor)
            ancestor[bAncestor] = aAncestor;
        return true;
    }

    static int findAncestor(int n) {
        if (n != ancestor[n]) {  // 루트 노드가 아니라면
            ancestor[n] = findAncestor(ancestor[n]);
        }
        return ancestor[n];
    }

}
