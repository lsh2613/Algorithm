package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] wires = new int[n][2];
        int[] maxConnection = new int[n];

        for (int i = 0; i < n; i++) {
            wires[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(wires, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            maxConnection[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires[i][1] > wires[j][1]) {
                    maxConnection[i] = Math.max(maxConnection[i], maxConnection[j] + 1);
                }
            }
        }

        System.out.println(n - Arrays.stream(maxConnection).max().getAsInt());
    }
}
