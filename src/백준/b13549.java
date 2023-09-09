//package 백준;
//
//import java.util.*;
//import java.io.*;
//class Node{
//    int idx, time;
//
//    Node(int idx, int time){
//        this.idx = idx;
//        this.time = time;
//    }
//}
//public class b13549 {
//    static int K;
//    //소요되는 시간을 줄이기 위해서 visited 선언
//    static boolean[] visited;
//    static int min = Integer.MAX_VALUE;
//    static final int MAX_NODE = 100_001;
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        visited = new boolean[MAX_NODE];
//
//        System.out.println(bfs(N));
//    }
//
//    static int bfs(int val){
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(val, 0));
//        visited[val] = true;
//
//        while(!q.isEmpty()){
//            Node now = q.poll();
//
//            if(now.idx == K)
//                return now.time;
//
//            if (now.idx * 2 <= MAX_NODE && !visited[now.idx * 2]) {
//                q.offer(new Node(now.idx * 2, now.time));
//                visited[now.idx * 2] = true;
//            }
//
//            if (now.idx - 1 >= 0 && !visited[now.idx - 1]) {
//                q.offer(new Node(now.idx - 1, now.time + 1));
//                visited[now.idx - 1] = true;
//            }
//
//            if (now.idx + 1 <= 100_000 && !visited[now.idx + 1]) {
//                q.offer(new Node(now.x + 1, now.time + 1));
//                visited[now.idx + 1] = true;
//            }
//        }
//        return -1;
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}

public class b13549 {
    static final int MAX_NODE = 100000;
    static List<Node>[] graph;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        //init
        graph = new List[MAX_NODE + 1];
        for (int i = 0; i < MAX_NODE + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int nowIdx = 0; nowIdx < MAX_NODE+1; nowIdx++) {
            if (nowIdx + 1 <= MAX_NODE)
                graph[nowIdx].add(new Node((nowIdx + 1), 1));
            if (nowIdx * 2 <= MAX_NODE)
                graph[nowIdx].add(new Node((nowIdx * 2), 0));
            if (nowIdx - 1 >= 0)
                graph[nowIdx].add(new Node((nowIdx - 1), 1));
        }
        d = new int[MAX_NODE + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        int res = dijkstra(start, end);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    static int dijkstra(int start, int end) {
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowDist = now.distance;
            int nowIdx = now.idx;

            if (d[nowIdx] < nowDist) continue; // 굳이 안 써줘도 되지만 d[nowIdx]로 이미 최솟값을 가지고 있는데 더 큰 값의 nowDist가 밑의
            // for문(최소 비용 업데이트 로직)을 실행해봤자 최소 비용을 가질 수 없기 때문에 불필요한 연산을 제거하기 위함이다.


            for (Node adj : graph[nowIdx]) {
                int adjIdx = adj.idx;
                int cost = d[nowIdx] + adj.distance;

                if (d[adjIdx] > cost) {
                    d[adjIdx] = cost;
                    pq.offer(new Node(adjIdx, cost));
                }
            }
        }
        return d[end];
    }
}
