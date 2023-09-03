package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import static java.lang.Math.abs;

public class b11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
        {
            int absA = abs(Integer.valueOf(a));
            int absB = abs(Integer.valueOf(b));
            if (absA == absB) {
                return a - b;
            }
            return absA - absB;
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            }
            else {
                pq.offer(x);
            }
        }
    }
}
