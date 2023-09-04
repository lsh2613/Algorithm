package 백준;

import java.io.*;
import java.util.*;

public class b16928 {
    static int N, M, cnt;
    static boolean[] visited;
    static Map<Integer, Integer> snakeAndLadder; // 뱀과 사다리의 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        snakeAndLadder = new HashMap<>();

        // 뱀과 사다리 등록
        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            snakeAndLadder.put(x, y);
        }

        bfs();
        System.out.println(cnt);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            cnt++;
            for(int i=0,qSize=q.size(); i<qSize; i++) {
                int now = q.poll();

                for(int j=1; j<=6; j++) {		//주사위값 계산
                    int move = now + j;
                    if (move == 100) return; // 도착
                    if(move > 100 || visited[move]) continue;

                    visited[move] = true;

                    //뱀, 사다리를 만남
                    if(snakeAndLadder.containsKey(move)) {
                        move = snakeAndLadder.get(move);
                    }

                    q.add(move);
                }
            }
        }
    }
}