package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weight = new int[n];

        for (int i=0; i<n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int sum = 0;
        for (int i=0; i<n; i++) {
            if (sum + 1 < weight[i]) {
                break;
            }

            sum += weight[i];
        }

        System.out.println(sum + 1);
    }
}
