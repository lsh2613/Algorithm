package 백준;

import java.util.ArrayList;
import java.util.Scanner;
/*
잘 나오는데 틀렸다고 뜸
반례를 모르겠어서 2606 문제 게시판에 올려둔 상태
 */
public class b2606 {
    static boolean infected[];
    static ArrayList<ArrayList<Integer>> graph;

    static void dfs(int n) {
        if (infected[n] == false) {
            infected[n] = true;
            ArrayList<Integer> list = graph.get(n);
            for (int i = 0; i < list.size(); i++) {
                dfs(list.get(i));
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int com = sc.nextInt();
        infected = new boolean[com+1];

        graph = new ArrayList<>();
        for (int i = 0; i <= com; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        dfs(1);

        int cnt = 0;
        for (boolean b : infected) {
            if (b)
                cnt++;
        }
        // 1번에 의한 감염 갯수 이므로 1번에 대한 횟수는 제외
        System.out.println(cnt-1);

    }
}
