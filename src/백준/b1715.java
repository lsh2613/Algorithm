package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class b1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>((p1, p2) -> p1 - p2);

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (pq.size() >= 2) {
            int sum = pq.poll() + pq.poll();
            cnt += sum;
            pq.offer(sum);
        }

        System.out.println(cnt);
    }
}
